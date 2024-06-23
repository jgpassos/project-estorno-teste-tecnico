package estornoProject.imps;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import estornoProject.interfaces.JsonConverter;
import estornoProject.model.User;

import java.util.List;

public class JsonConverterImp implements JsonConverter {
    @Override
    public String jsonConverter(List<User> users) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(users);
    }
}
