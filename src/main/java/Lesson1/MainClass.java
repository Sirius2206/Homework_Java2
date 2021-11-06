package Lesson1;

//Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса. Эти классы должны уметь бегать и
// прыгать (методы просто выводят информацию о действии в консоль).
//        Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники должны выполнять
//        соответствующие действия (бежать или прыгать), результат выполнения печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).
//        Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.
//        * У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения на бег и прыжки.
//        Если участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет.

public class MainClass {

    public static void main(String[] args) {

        Participant[] participants = {
                new Cat("Борис", 600, 2),
                new Human("Аркадий", 500, 4),
                new Robot("BD-m2", 1000, 1)};

        Obstacle[] obstacles ={
                new RunningTrack(200),
                new JumpingWall(1),
                new JumpingWall(2),
                new RunningTrack(301)};


        System.out.println("Участники вышли на полосу препятствий и разминаются.");
        for (int i = 0; i < participants.length; i++){
            participants[i].running();
            participants[i].jumping();
            System.out.println();
        }

        System.out.println("Соревнования начинаются!");
        for (int i = 0; i < participants.length; i++){
            for (int j = 0; j < obstacles.length; j++) {
                participants[i].overcome(obstacles[j]);
                if (!participants[i].isSuccess()) {
                    System.out.println(participants[i].getName() + " выбывает из соревнований");
                    break;
                }
                System.out.println();
            }
        }

        for (int i = 0; i < participants.length; i++){
            if (participants[i].isSuccess()) System.out.println(participants[i].getName() + " преодолел все препятствия!");
        }
    }

}
