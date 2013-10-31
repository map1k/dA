package dataArt;

public class Magazine    //класс магазина
{
    int bullet;     //кол-во патронов
    int max;         //емкость

    Magazine()       //конструктор пустого магазина по умолчанию
    {
        this.max = 30;
        this.bullet = 0;
    }

    Magazine(int m)      //конструкотр магазина с заданым кол-вом загруженых патроном и емкостью
    {
        if(30 ==  m)
        {
            this.max = m;
            this.bullet = 30;
        }
        if(45 ==  m)
        {
            this.max = m;
            this.bullet = 45;
        }
        if(60 ==  m)
        {
            this.max = m;
            this.bullet = 60;
        }
        else
        {
            this.max = 30;
            this.bullet = 0;
        }
    }

    int getBullets()
    {
         return bullet;
    }

    void dischargeBullets(int b)  //изьятие патронов
    {
        if(bullet - b < 0)
        {
            this.bullet = 0;
            try
            {
                Thread.sleep(250*bullet);  //задержка
            }
            catch (InterruptedException e)
            {
                //System.out.println("");
            }
        }
        else
            for(int i = 0; i < b; i++){
                this.bullet -= 1;
                try
                {
                    Thread.sleep(250);  //задержка
                }
                catch (InterruptedException e)
                {
                    //System.out.println("");
                }
            }

    }

    void loadBullet(int b)   //добавление патронов
    {
        if(bullet+b <= max)
            for(int j = 0; j < b; j++){
                this.bullet += 1;
                try
                {
                    Thread.sleep(1000);  //задержка
                }
                catch (InterruptedException e)
                {
                    //System.out.println("");
                }
            }
        else {
            int t = max - bullet;
            for(int j = 0; j < t; j++){
                this.bullet += 1;
                try
                {
                    Thread.sleep(1000);  //задержка
                }
                catch (InterruptedException e)
                {
                    //System.out.println("");
                }
            }
        }
    }
}
