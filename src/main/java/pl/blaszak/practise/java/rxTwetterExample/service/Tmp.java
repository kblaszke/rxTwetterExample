package pl.blaszak.practise.java.rxTwetterExample.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Service;
import pl.blaszak.practise.java.rxTwetterExample.domain.Tweet;
import rx.Observable;

import java.util.Arrays;

@Service
public class Tmp {

    public void execute() {

        String stringTweet1 = "{\"createdAt\":{\"date\":{\"year\":2018,\"month\":12,\"day\":21},\"time\":{\"hour\":12,\"minute\":31,\"second\":47,\"nano\":762000000}},\"userId\":123456,\"title\":\"My first tweet\",\"body\":\"This is body of my first tweet\"}";
        String stringTweet2 = "{\"createdAt\":{\"date\":{\"year\":2018,\"month\":12,\"day\":21},\"time\":{\"hour\":12,\"minute\":40,\"second\":47,\"nano\":762000000}},\"userId\":123456,\"title\":\"My second tweet\",\"body\":\"This is body of my second tweet\"}";
        String stringTweet3 = "{\"createdAt\":{\"date\":{\"year\":2018,\"month\":12,\"day\":21},\"time\":{\"hour\":12,\"minute\":43,\"second\":47,\"nano\":762000000}},\"userId\":654321,\"title\":\"Zuza's first tweet\",\"body\":\"This is body of Zuza's first tweet\"}";
        String stringTweet4 = "{\"createdAt\":{\"date\":{\"year\":2018,\"month\":12,\"day\":21},\"time\":{\"hour\":12,\"minute\":45,\"second\":47,\"nano\":762000000}},\"userId\":654321,\"title\":\"Zuza's second tweet\",\"body\":\"This is body of Zuza's second tweet\"}";
        String stringTweet5 = "{\"createdAt\":{\"date\":{\"year\":2018,\"month\":12,\"day\":21},\"time\":{\"hour\":12,\"minute\":47,\"second\":47,\"nano\":762000000}},\"userId\":123456,\"title\":\"My tird tweet\",\"body\":\"This is body of my third tweet\"}";
        String stringTweet6 = "{\"createdAt\":{\"date\":{\"year\":2018,\"month\":12,\"day\":21},\"time\":{\"hour\":12,\"minute\":50,\"second\":47,\"nano\":762000000}},\"userId\":654321,\"title\":\"Zuza's third tweet\",\"body\":\"This is body of Zuza's third tweet\"}";
        Gson gson = new GsonBuilder().create();

        Observable<String> observable = Observable.from(Arrays.asList(stringTweet1, stringTweet2, stringTweet3, stringTweet4, stringTweet5, stringTweet6)); // from(stringFuture);

        observable
                .map(st -> gson.fromJson(st, Tweet.class))
                .map(t -> t.getUserId() + ": " + t.getTitle())
                .filter(tr -> {System.out.println(tr); return true;})
                .subscribe();


    }
}
