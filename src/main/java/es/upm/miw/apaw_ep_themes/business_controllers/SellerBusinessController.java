package es.upm.miw.apaw_ep_themes.business_controllers;

import es.upm.miw.apaw_ep_themes.daos.SellerDao;
import es.upm.miw.apaw_ep_themes.documents.Seller;
import es.upm.miw.apaw_ep_themes.documents.Transaction;
import es.upm.miw.apaw_ep_themes.dtos.SellerDto;
import es.upm.miw.apaw_ep_themes.dtos.TransactionDto;
import es.upm.miw.apaw_ep_themes.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class SellerBusinessController {
    private SellerDao sellerDao;
    static final String ID_ID = "/{id}";
    static final String NAME = "/name";

    private SellerBusinessController sellerBusinessController;

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
        System.out.print(this.sellerDao.findById(id));
        return this.sellerDao.findById(id).orElseThrow(() -> new NotFoundException("Seller id: " + id));
    }

}