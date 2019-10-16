package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.business_controllers.MaterialBusinessController;
import es.upm.miw.apaw_ep_themes.dtos.MaterialDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(MaterialResource.MATERIALS)
public class MaterialResource {
    static final String MATERIALS = "/materials";
    static final String ID_ID = "/{id}";

    private MaterialBusinessController materialBusinessController;

    @Autowired
    public MaterialResource(MaterialBusinessController materialBusinessController) {
        this.materialBusinessController = materialBusinessController;
    }

//    @RequestMapping(value="/restDelete",method= RequestMethod.DELETE)
//    public String Delete(@RequestParam(value = "id") Integer id) {
//        System.out.println("DELETE ID:" + id);
//        return SUCCESS;
//    }

    @PostMapping
    public MaterialDto create(@RequestBody MaterialDto materialDto) {
        //materialDto.validate();
        return this.materialBusinessController.create(materialDto);
    }


    @DeleteMapping(value = ID_ID)
    public void delete(@PathVariable String id) {
        this.materialBusinessController.delete(id);
    }
}
