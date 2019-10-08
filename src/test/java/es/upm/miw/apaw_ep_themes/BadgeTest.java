package es.upm.miw.apaw_ep_themes;

import es.upm.miw.apaw_ep_themes.daos.SellerDao;
import es.upm.miw.apaw_ep_themes.documents.Seller;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class)
public class BadgeTest {

    @Autowired
    private SellerDao sellerDao;

    @Test
   public  void testGenerateBadge() {
        String badge = new Badge().generateBadge("Heroku", "v2.2.0-SNAPSHOT");
        assertNotNull(badge);
        assertEquals("<svg", badge.substring(0, 4));
    }

    @Test
    public  void testCreate() {
        Seller seller = new Seller("123", 1);
        seller = sellerDao.save(seller);
        System.out.println(seller);
    }

}
