package es.upm.miw.apaw_ep_themes.business_controllers;

import es.upm.miw.apaw_ep_themes.daos.SellerDao;
import es.upm.miw.apaw_ep_themes.documents.Seller;
import es.upm.miw.apaw_ep_themes.dtos.SellerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class SellerBusinessController {
    private SellerDao sellerDao;

    @Autowired
    public SellerBusinessController( SellerDao sellerDao) {
        this.sellerDao = sellerDao;
    }


    public SellerDto create(SellerDto sellerDto) {
        String  name = sellerDto.getName();
        Integer credit = sellerDto.getCredit();
        Seller seller = new Seller(name,credit);
        this.sellerDao.save(seller);
        return new SellerDto(seller);
    }

    public List<SellerDto> readAll() {
        List<Seller> seller = this.sellerDao.findAll();
        return seller.stream().map(SellerDto::new).collect(Collectors.toList());
    }

    public List<Seller> findSellerByName(String name) {
//        List<Seller> sellerList = this.sellerDao.findSellerByName(name);
//        SellerDto dto = null;
//        List<SellerDto> list = new ArrayList<>();
//        for(Seller seller:sellerList){
//            dto = new SellerDto(seller);
//            list.add(dto);
//        }
//        return list;

        return this.sellerDao.findByName(name);
    }

}