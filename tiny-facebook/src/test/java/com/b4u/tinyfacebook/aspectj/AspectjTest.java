package com.b4u.tinyfacebook.aspectj;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * @author: hzy
 * @since:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AspectjConfig.class)
@Ignore
public class AspectjTest {

    private static final String MO_LI_HUA = "molihua";
    private static final String QI_LI_XIANG = "qilixiang";
    private static final String DA_HE_ZHI_WU = "dahezhiwu";

    @Autowired
    private Performance goodPerformance;

    @Autowired
    private Performance badPerformance;

    @Autowired
    private PerformCountAspect performCountAspect;

    @Test
    public void testGoodPerformance() {
        goodPerformance.perform();
    }

    @Test
    public void testBadPerformance() {
        badPerformance.perform();
    }

    @Test
    public void testPerformanceCount() {
        goodPerformance.perform(MO_LI_HUA);
        goodPerformance.perform(QI_LI_XIANG);
        goodPerformance.perform(DA_HE_ZHI_WU);
        goodPerformance.perform(MO_LI_HUA);

        assertEquals(2, performCountAspect.getPerformCount(MO_LI_HUA));
        assertEquals(1, performCountAspect.getPerformCount(QI_LI_XIANG));
        assertEquals(1, performCountAspect.getPerformCount(DA_HE_ZHI_WU));
    }
}
