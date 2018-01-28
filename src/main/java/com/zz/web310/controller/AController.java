package com.zz.web310.controller;


import com.google.gson.stream.JsonReader;
import com.ibm.watson.developer_cloud.conversation.v1.Conversation;
import com.ibm.watson.developer_cloud.conversation.v1.model.InputData;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;
import com.ibm.watson.developer_cloud.personality_insights.v3.PersonalityInsights;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.Content;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.Profile;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.ProfileOptions;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.zz.web310.model.ConversationBizResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.*;

@RestController
@RequestMapping(value = "/traveling_frog")
public class AController {


    @RequestMapping(value = "/status_change")
    public void change(){

    }


    @RequestMapping(value = "/11")
    public void add(){
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("X-Watson-Learning-Opt-Out", "true");
        PersonalityInsights service = new PersonalityInsights("2017-10-13");
        service.setUsernameAndPassword("ad26ffc9-8506-4ce9-9704-18f573091b00",  "UNlceYtGGCAI");

        String path = AController.class.getClassLoader().getResource("profile.json").getPath();
        try {
            JsonReader jReader = new JsonReader(new FileReader(path));
            Content content = GsonSingleton.getGson().fromJson(jReader, Content.class);
            ProfileOptions options = new ProfileOptions.Builder()
                    .content(content).consumptionPreferences(true)
                    .rawScores(true).build();
            Profile profile = service.profile(options).execute();
            System.out.println(profile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/conversation", method = RequestMethod.POST)
    public ConversationBizResult Conversation(@RequestBody String sentance){
        Conversation service = new Conversation(Conversation.VERSION_DATE_2017_05_26);
        service.setUsernameAndPassword("5a95c282-d8e4-467b-a868-1c399a51fba5", "j8DIaSVYXK0f");

        String workspaceId = "4b3374ad-f5de-4e06-bc6c-efde5651a555";

        InputData input = new InputData.Builder(sentance).build();

        MessageOptions options = new MessageOptions.Builder(workspaceId)
                .input(input)
                .build();

        MessageResponse response = service.message(options).execute();


        String result = response.getOutput().getText().get(0);
        if(result!=null && !result.isEmpty()){
            return ConversationBizResult.builder()
                    .status(ConversationBizResult.SUCC)
                    .msg(response.getOutput().getText().get(0))
                    .build();
        }
        else
            return ConversationBizResult.builder()
                    .status(ConversationBizResult.FAILED)
                    .build();
    }
}
