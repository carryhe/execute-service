import com.hongkun.execute.business.service.SinaAccountService;
import com.hongkun.execute.common.dto.GetSinaAccountDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author HeXG
 * @since 2017/12/26
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring.xml","classpath:springmvc.xml"})
public class SinaAccountServiceTest {

    @Resource
    private SinaAccountService sinaAccountService;

    @Test
    public void testSaveSinaAccount(){
        String string ="";
        sinaAccountService.saveSinaAccount(string);

    }

    @Test
    public void testGetsinaAccount(){
        GetSinaAccountDto sinaAccount = sinaAccountService.getSinaAccount("山西", "1");
        System.out.println(sinaAccount);
    }

    @Test
    public void testUpdateSinaAccount(){


    }

}
