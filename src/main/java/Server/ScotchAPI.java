package Server;

import com.google.gson.Gson;
import Models.Whisky;
import Models.Whisky_Storage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/api/whiskies/")
public class ScotchAPI {

    // create new whiskies
    @PostMapping
    @ResponseBody
    public ModelAndView createwhisky(
            @RequestParam("name") String name,
            @RequestParam("rating") double rating
    ) {
        Whisky whisky = new Whisky (name, rating);
        Whisky_Storage.whiskies.put(whisky.id, whisky);
        return new ModelAndView("forward:/whiskies");
    }



    // read all the whiskies
    @GetMapping
    @ResponseBody
    public List<Whisky> getAllWhiskies() {
        Collection<Whisky> whiskies = Whisky_Storage.whiskies.values();
        return new ArrayList<>(whiskies);
    }

    // read one whisky
    @GetMapping("/{id}")
    @ResponseBody
    public Whisky getOneWhisky(@PathVariable("id") int id) {
        Whisky result = Whisky_Storage.whiskies.get(id);
        return result;
    }

    // update a given whisky
    @PutMapping("/{id}")
    @ResponseBody
    public Whisky updateWhisky(
            @PathVariable("id") int id,
            @RequestBody String body
    ) {
        Gson gson = new Gson();
        Whisky newWhisky = gson.fromJson(body, Whisky.class);
        Whisky oldWhisky = Whisky_Storage.whiskies.get(id);
        oldWhisky.name = newWhisky.name;
        oldWhisky.rating = newWhisky.rating;
        return oldWhisky;
    }

    // destroy
    @DeleteMapping("/{id}")
    @ResponseBody
    public Whisky deleteWhisky(@PathVariable("id") int id) {

        Whisky whisky = Whisky_Storage.whiskies.get(id);
        Whisky_Storage.whiskies.remove(id);
        return whisky;
    }
}
