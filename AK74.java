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
    private int trigger = 0; //предохронитель
    private Magazine mag;     //магазин по умолчанию
    private boolean chargingHandle = false;   //затвор
    private boolean bayonet;   //штык-нож
    private ReflexSight reflexSight;    //Прицел

    public void setTriggerPull(boolean triggerPull)
    {
        this.triggerPull = triggerPull;
    }

    boolean triggerPull = false;

    boolean isReady() {
        try {
        return mag != null && mag.bullet > 0 && chargingHandle && trigger > 0;
        } catch (NullPointerException e) {
            System.out.println("Add magazine.");
        }
        return false;
    }


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
       // bulletsInMag = mag.getBullets();
    }
    void pullTrigger ()
    {
    switch (trigger)
    {
        case (0) :
        break; //do nothing
        case (1) :
        shoot();
        break;
        case (2) :
        while (triggerPull) shoot();
        break;
    }
    }

    public void shoot()       //метод выстрела
    {
        if(isReady())
            if (chargingHandle )
            {
        int bullet = mag.getBullets(); //этот метод гарантированно уменьшает количество патрон в магазине
        if (bullet > 0) { System.out.println("BANG!");
                try
                {
                    Thread.sleep(100);  //задержка между выстрелами, при 600 выстрелов минуту
                }
                catch (InterruptedException e)
                {
                    // System.out.println("1");

                } }
        else chargingHandle = false;
            }
    }


    public void setMag(Magazine mag)   //добавление магазина
    {
        this.mag = mag;
      //  bulletsInMag = mag.getBullets();
    }

    public void addMoreB (int aB)   //добавление патронов в магазин
    {
        mag.loadBullet(aB);
        //bulletsInMag = mag.getBullets();
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



