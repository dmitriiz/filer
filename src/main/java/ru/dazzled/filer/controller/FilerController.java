package ru.dazzled.filer.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.dazzled.filer.EntityManager;
import ru.dazzled.filer.model.FilerEntity;
import ru.dazzled.filer.model.FilerEntityType;

/**
 *
 * @author dmitriiz
 */
@Controller
//@RequestMapping("/")
public class FilerController {

    @Autowired
    private EntityManager entityManager;

    @RequestMapping("/")
    public String getIndex(Device device) {
        /*if (device.isMobile()) {
         return "mobile/index";
         } else if (device.isTablet()) {
         return "tablet/index";
         } else {
         return "desktop/index";
         }*/
        return "tablet/index";
    }

    @RequestMapping("/list/{type}")
    public String getEntities(@PathVariable FilerEntityType type, Model model) {
        List<FilerEntity> list = new ArrayList<>();
        list.addAll(entityManager.getEntities(type));
        Collections.sort(list, new EntityComparator());
        model.addAttribute("entities", list);
        return "tablet/list";
    }

    @RequestMapping("/get/{guid}")
    public String readEntity(@PathVariable String guid, Model model) {
        model.addAttribute("entity", entityManager.getEntity(guid));
        return "read";
    }

    @RequestMapping("/icon/{guid}")
    public String readIcon(@PathVariable String guid, Model model) {
        model.addAttribute("entity", entityManager.getEntity(guid));
        return "icon";
    }

    class EntityComparator implements Comparator<FilerEntity> {

        @Override
        public int compare(FilerEntity e1, FilerEntity e2) {
            return e1.getName().compareTo(e2.getName());
        }
    }
}
