package es.upm.miw.apaw_ep_themes.business_controllers;

import es.upm.miw.apaw_ep_themes.daos.SellerDao;
import es.upm.miw.apaw_ep_themes.documents.Seller;
import es.upm.miw.apaw_ep_themes.documents.SellerBuilder;
import es.upm.miw.apaw_ep_themes.dtos.SellerDto;
import es.upm.miw.apaw_ep_themes.exceptions.NotFoundException;
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
        Seller seller = new SellerBuilder().setName(sellerDto.getName()).setCredit(sellerDto.getCredit()).build();
        this.sellerDao.save(seller);
        return new SellerDto(seller);
    }

    public SellerDto read(String id) {
        return new SellerDto(this.findSellerById(id));
    }

    public List<SellerDto> readAll() {
        List<Seller> seller = this.sellerDao.findAll();
        return seller.stream().map(SellerDto::new).collect(Collectors.toList());
    }

    public SellerDto readName(String id) {
        return new SellerDto(this.findSellerById(id));
    }

    public List<SellerDto> findByName(String value) {
        return this.sellerDao.findAll().stream()
                .filter(seller -> seller.getName().equals(value))
                .map(SellerDto::new)
                .collect(Collectors.toList());
    }

    public void updateName(String id, String name) {
        Seller seller = this.findSellerById(id);
        seller.setName(name);
        this.sellerDao.save(seller);
    }

    private Seller findSellerById(String id) {
        return this.sellerDao.findById(id).orElseThrow(() -> new NotFoundException("Seller id: " + id));
    }

}