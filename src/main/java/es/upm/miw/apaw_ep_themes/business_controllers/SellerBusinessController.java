package es.upm.miw.apaw_ep_themes.business_controllers;

import es.upm.miw.apaw_ep_themes.daos.SellerDao;
import es.upm.miw.apaw_ep_themes.documents.Seller;
import es.upm.miw.apaw_ep_themes.dtos.SellerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/seller")
public class SellerBusinessController {
    @Autowired
    private SellerDao sellerDao;


    @RequestMapping("/create")
    public SellerDto create(SellerDto sellerDto) {
        Seller seller = new Seller(sellerDto.getName(), sellerDto.getCredit());
        this.sellerDao.save(seller);
        return new SellerDto(seller);
    }

    public List<SellerDto> readAll() {
        List<Seller> seller = this.sellerDao.findAll();
        return seller.stream().map(SellerDto::new).collect(Collectors.toList());
    }
}