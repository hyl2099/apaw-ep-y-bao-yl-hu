package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.business_controllers.MaterialBusinessController;
import es.upm.miw.apaw_ep_themes.dtos.MaterialDto;
import es.upm.miw.apaw_ep_themes.exceptions.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(MaterialResource.MATERIALS)
public class MaterialResource {
    static final String MATERIALS = "/materials";
    static final String ID_ID = "/{id}";
    static final String NAME = "{name}";

    private MaterialBusinessController materialBusinessController;

    @Autowired
    public MaterialResource(MaterialBusinessController materialBusinessController) {
        this.materialBusinessController = materialBusinessController;
    }

    @PostMapping
    public MaterialDto create(@RequestBody MaterialDto materialDto) {
        materialDto.validate();
        return this.materialBusinessController.create(materialDto);
    }

    @DeleteMapping(value = ID_ID)
    public void delete(@PathVariable String id) {
        if (id == null) {
            throw new BadRequestException("Incomplete materialDto. ");
        }
        this.materialBusinessController.delete(id);
    }

    @PatchMapping(value = ID_ID)
    public void patch(@PathVariable String id, @RequestBody MaterialDto materialDto) {
        materialDto.validate();
        this.materialBusinessController.patch(id, materialDto);
    }


}
