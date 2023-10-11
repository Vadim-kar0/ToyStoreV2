package Controller;

import Model.Data.LotteryParticipant;
import Model.Data.Toy;
import ModelService.LotteryService;
import View.UserView;

public class Controller {
    LotteryService lotteryService = new LotteryService();
    UserView userView = new UserView();

    public  void start(){
        userView.set("""
                Выберете функцию:
                1 - Добавить игрушку самостоятельно
                2 - Добавить список готовых игрушек(используется для проверки)
                3 - Добавть участника лоттереи
                4 - Добавить список готовых участников(используется для проверки)
                5 - Провести лоттерею
                6 - exit
                """);
        int answer = userView.getInt();
        switch (answer){
            case 1:
                System.out.println("Введите id игрушки:");
                int id = userView.getInt();
                System.out.println("Введите имя игрушки:");
                String name = userView.getLine();
                System.out.println("Введите количество игрушки:");
                int count = userView.getInt();
                System.out.println("Введите шанс выпадения игрушки:");
                int dropChance = userView.getInt();
                lotteryService.putToy(new Toy(id,name,count,dropChance));
                start();
                break;
            case 2:
                lotteryService.putToy(new Toy(7,"Машинка",1,5));
                lotteryService.putToy(new Toy(6,"Самолёт",2,3));
                lotteryService.putToy(new Toy(5,"Конструктор",3,2));
                lotteryService.putToy(new Toy(4,"Кубики",4,5));
                lotteryService.putToy(new Toy(3,"Пистолет",2,3));
                lotteryService.putToy(new Toy(2,"Бакуган",3,2));
                lotteryService.putToy(new Toy(1,"Бионикл",1,1000));
                start();
                break;
            case 3:
                String s = userView.getLine();
                lotteryService.putParticipant(new LotteryParticipant(s));
                start();
                break;
            case 4:
                lotteryService.putParticipant(new LotteryParticipant("Аня1",1));
                lotteryService.putParticipant(new LotteryParticipant("Ваня3",3));
                lotteryService.putParticipant(new LotteryParticipant("Таня2",2));
                lotteryService.putParticipant(new LotteryParticipant("Галя4",4));
                lotteryService.putParticipant(new LotteryParticipant("Игор5",5));
                lotteryService.putParticipant(new LotteryParticipant("Моля"));
                lotteryService.putParticipant(new LotteryParticipant("Жора6",6));
                lotteryService.putParticipant(new LotteryParticipant("Боря7",7));
                lotteryService.putParticipant(new LotteryParticipant("Коля"));
                lotteryService.putParticipant(new LotteryParticipant("Толя4",4));
                lotteryService.putParticipant(new LotteryParticipant("Поля6",6));
                start();
                break;
            case 5:

                while (!lotteryService.getLottery().getParticipants().isEmpty() &&
                        !lotteryService.getLottery().getToys().isEmpty()){
                    lotteryService.getToy();
                }
                break;
            case 6:
                break;
            default: start();
        }

    }
}
