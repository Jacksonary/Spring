import com.hhu.service.BookShopService;
import com.hhu.service.Cashier;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

/**
 * Created by WeiguoLiu on 2018/3/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestSpringHibernate {
    @Autowired
    private Cashier cashier;

    @Autowired
    private BookShopService bookShopService;

    @Test
    public void testCashier() {
        cashier.checkout("jack", Arrays.asList(new String[]{"IBS-2145", "IBS-3452"}));
    }

    @Test
    public void testBookShopService() {
        bookShopService.purchase("jack", "IBS-2145");
    }
}
