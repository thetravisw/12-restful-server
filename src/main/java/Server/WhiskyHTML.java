package Server;

import com.google.gson.Gson;
import Models.Whisky;
import Models.Whisky_Storage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.lang.management.MonitorInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/whiskies")
public class WhiskyHTML {
    // list all scotch page
    @GetMapping
    public String showAllwhiskies(Model model) {
        Collection<Whisky> whiskies = Whisky_Storage.whiskies.values();
        List<Whisky> list = new ArrayList<>(whiskies);

        model.addAttribute("whiskies", whiskies);
        return "all_whiskies";
    }

    // create HTML forn.js
    @GetMapping("/new")
    public String createMountainForm() {
        return "create_whisky";
    }

    // update HTML form.js
    @GetMapping("/{id}/edit")
    public String editWhiskyForm(
            @PathVariable("id") int id,
            Model model
    ) {
        Whisky whisky = Whisky_Storage.whiskies.get(id);

        model.addAttribute("id", whisky.id);
        model.addAttribute("name", whisky.name);
        model.addAttribute("rating", whisky.rating);

        return "edit_whisky";
    }
}
