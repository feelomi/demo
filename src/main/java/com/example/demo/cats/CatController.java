package com.example.demo.cats;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.demo.cats.cat.*;

import java.util.List;

@Controller
@RequestMapping("/team")
public class CatController {

    private final CatService catService;

    public CatController(CatService catService) {
        this.catService = catService;
    }

    @GetMapping
    public String cat(Model model, @SortDefault.SortDefaults({ @SortDefault("catName")}) Pageable pageable) {
        model.addAttribute( "title", "Cats");
        model.addAttribute("cats", catService.getCats(pageable));
        return "team/list";
    }

    @GetMapping("/create")
    public String createCatForm(Model model) {
        model.addAttribute("cat", new CreateCatFromData());
        model.addAttribute("genders", List.of(Gender.MALE, Gender.FEMALE));
        return "team/edit";
    }

    @PostMapping("/create")
    public String createTeamMember(@Validated(CreateCatValidationGroupSequence.class)
                                 @ModelAttribute("cat") CreateCatFromData formData,
                               BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("genders", List.of(Gender.MALE, Gender.FEMALE));
            return "team/edit";
        }
        catService.createCat(formData.toParameters());
        return "redirect:/team";
    }

    @GetMapping("/{id}")
    public String editCatForm(@PathVariable("id") CatId catId, Model model) {
        Cat cat = catService
                .getCat(catId)
                .orElseThrow(() -> new CatNotFoundExc(catId));
        model.addAttribute("cat", EditCatFormData.fromCat(cat));
        model.addAttribute("genders", List.of(Gender.MALE, Gender.FEMALE));
        model.addAttribute("editMode", EditMode.UPDATE);
        return "team/edit";
    }

    @PostMapping("/{id}")
    public String editTeamMember(@PathVariable("id") CatId catId,
                                 @Validated(EditCatValidationGroupSequence.class)
                                   @ModelAttribute("cat") EditCatFormData formData,
                                   BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("genders", List.of(Gender.MALE, Gender.FEMALE));
            model.addAttribute("editMode", EditMode.UPDATE);
            return "team/edit";
        }
        catService.editCat(catId, formData.toParameters());
        return "redirect:/team";
    }

    @PostMapping("/{id}/delete")
    public String deleteTeamMember(@PathVariable("id") CatId catId,
                                   RedirectAttributes redirectAttributes) {
        Cat member = catService.getCat(catId)
                .orElseThrow(() -> new CatNotFoundExc(catId));
        catService.deleteCat(catId);
        redirectAttributes.addFlashAttribute("deletedCatName",
                member.getCatName());
        return "redirect:/team";
    }
}
