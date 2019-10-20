package es.upm.miw.apaw_ep_themes.business_controllers;


import es.upm.miw.apaw_ep_themes.daos.MaterialDao;
import es.upm.miw.apaw_ep_themes.documents.Material;
import es.upm.miw.apaw_ep_themes.dtos.MaterialDto;
import es.upm.miw.apaw_ep_themes.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MaterialBusinessController {
    private MaterialDao materialDao;

    @Autowired
    public MaterialBusinessController(MaterialDao materialDao) {
        this.materialDao = materialDao;
    }

    public MaterialDto create(MaterialDto materialDto) {
        String id = materialDto.getId();
        String name = materialDto.getName();
        double price = materialDto.getPrice();
        String type = materialDto.getType();
        Material material = new Material(id,name,price,type);
        this.materialDao.save(material);
        return new MaterialDto(material);
    }

    private Material findHouseByIdAssured(String id) {
        return this.materialDao.findById(id).orElseThrow(() -> new NotFoundException("Material id: " + id));
    }

    public void delete(String id){
        Material material = findHouseByIdAssured(id);
        this.materialDao.delete(material);
    }

    public void patch(String id, MaterialDto  materialDto) {

        Material material = findMaterialById(id);
        material.setPrice(materialDto.getPrice());
        Material ss = materialDao.save(material);
        System.out.println(ss);
    }

    private Material findMaterialById(String id) {
        return this.materialDao.findById(id).orElseThrow(() -> new NotFoundException("User id: " + id));
    }

}
