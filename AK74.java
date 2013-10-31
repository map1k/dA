package dataArt;

/**
 * Created with IntelliJ IDEA.
 * User: M
 * Date: 28.10.13
 * Time: 22:47
 * To change this template use File | Settings | File Templates.
 */
public class AK74
{
    int trigger = 0;                   //предохронитель
    Magazine mag;     //магазин по умолчанию
    boolean chargingHandle = false;   //затвор
    boolean bayonet;   //штык-нож
    ReflexSight reflexSight;

    public void setReflexSight(ReflexSight reflexSight)
    {
        this.reflexSight = reflexSight;
    }

    public AK74()             //конструктор по умолчанию
    {
    }

    public AK74(Magazine mag)    //конструктор с заданым магазином
    {
        this.mag = mag;
    }

    public void shoot()       //метод выстрела
    {   try {
        if(mag != null && mag.bullet > 0 && chargingHandle && trigger > 0)
            if (trigger == 1)
                System.out.println("BANG!"); //звук выстрела
            if(trigger == 2)
                while (true)
                {

                    if(mag.bullet > 0){
                        System.out.println("BANG!"); //звук выстрела
                        mag.bullet--;
                        try
                        {
                            Thread.sleep(100);  //задержка между выстрелами, при 600 выстрелов минуту
                        }
                        catch (InterruptedException e)
                        {
                           // System.out.println("1");

                        }
                    }
                }
    } catch (NullPointerException e) {
        System.out.println("Add magazine.");
    }
    }

    public void shoot(int q)       //метод выстрела с заданым кол-вом раз
    {    try {
        if(mag != null && mag.bullet > 0 && chargingHandle && trigger > 0)
            if (trigger == 1)
                System.out.println("BANG!"); //звук выстрела
            if(trigger == 2)
            for(int t = 0; t < q; t++)
            {

                if(mag.bullet > 0){
                    System.out.println("BANG!"); //звук выстрела
                    mag.bullet--;
                    try
                    {
                        Thread.sleep(100);  //задержка между выстрелами, при 600 выстрелов минуту
                    }
                    catch (InterruptedException e)
                    {
                        // System.out.println("1");

                    }
                }
            }
    } catch (NullPointerException e) {
        System.out.println("Add magazine.");
    }
    }

    public void setMag(Magazine mag)   //добавление магазина
    {
        this.mag = mag;
    }

    public void setTriggerToOff()     //установка предохранителя
    {
        this.trigger = 0;
    }

    public void setTriggerToSemiAutomatic()   //установка предохранителя в полуавтоматический режим
    {
        this.trigger = 1;
    }

    public void setTriggerToFullAutomatic()  //установка предохранителя в автоматический режим
    {
        this.trigger = 2;
    }

    void pullChargingHandle ()    //взведение затвора перед стрельбой
    {

        chargingHandle = true;
    }

    public void addBayonet()     //добавление штык-ножа
    {
        this.bayonet = true;
    }

    public void hitWithABayonet()  //метод удара штыком
    {
        if(bayonet)
            System.out.println("AAA, DIE!");
        else
            System.out.println("Bayonet is not added");
    }
}



