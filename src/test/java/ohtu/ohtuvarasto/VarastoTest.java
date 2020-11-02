package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }

    @Test
    public void toStringToimii() {
        assertEquals(varasto + "", "saldo = 0.0, vielä tilaa 10.0");
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void konstruktoriLuoTaydenVaraston() {
        Varasto v = new Varasto(10,4);

        assertEquals(4, v.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void konstruktoriEiLuoNegatiivistaVarastoa() {
        Varasto v1 = new Varasto(-10);
        Varasto v2 = new Varasto(-10, 5);

        assertEquals(0, v1.getTilavuus(), vertailuTarkkuus);
        assertEquals(0, v2.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void liianSuuriAlkusaldo() {
        Varasto v = new Varasto(5,10);

        assertEquals(5, v.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void negatiivinenAlkusaldo() {
        Varasto v = new Varasto(10, -5);

        assertEquals(0, v.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void eiTuleLiianTayteen() {
        varasto.lisaaVarastoon(15);

        assertEquals(10, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void paljonkoMahtuuEiNegatiivinen() {
        varasto.lisaaVarastoon(15);

        assertEquals(0, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void eiVoiOttaaLiikaa() {
        varasto.lisaaVarastoon(5);
        varasto.otaVarastosta(7);

        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void tilavuusPysyySamana() {
        varasto.lisaaVarastoon(5);
        varasto.otaVarastosta(7);

        assertEquals(10, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    
    @Test
    public void eiLisataNegatiivista() {
        varasto.lisaaVarastoon(-2);

        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void eiOtetaNegatiivista() {
        varasto.otaVarastosta(-2);
        
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
}