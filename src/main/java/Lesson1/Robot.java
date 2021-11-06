package Lesson1;

public class Robot implements Participant {
    private String name;
    private int runningDistance;
    private int jumpHeight;
    private boolean success = true;

    public Robot(String name, int runningDistance, int jumpHeight) {
        this.name = name;
        if (runningDistance < 0) {
            this.runningDistance = 0;
        }else {
            this.runningDistance = runningDistance;
        }
        if (jumpHeight < 0){
            this.jumpHeight = 0;
        }else{
            this.jumpHeight = jumpHeight;
        }

    }

    public void overcome(Obstacle obstacle){
        if (obstacle instanceof JumpingWall){
            this.jumping((JumpingWall) obstacle);
        }else{
            this.running((RunningTrack) obstacle);
        }
    }

    public boolean isSuccess() {
        return success;
    }

    public String getName() {
        return name;
    }

    public void running(){
        System.out.println(this.name + " не нуждается в разминке.");
    }

    public void running(RunningTrack rt){
        if(success == false) return;
        if (rt.getDistance() <= runningDistance){
            System.out.println(this.name + " от Boston Dynamics побежал.");
            this.runningDistance -= rt.getDistance();
        }else {
            System.out.println(this.name + " перегорел.");
            this.success = false;
        }
    }

    public void jumping(){ System.out.println(this.name + " не нуждается в разминке.");}

    public void jumping(JumpingWall jw){
        if(success == false) return;
        if (jw.getHeight() <= jumpHeight){
            System.out.println(this.name + " смог перепрыгнуть через препятствие.");
        }else {
            System.out.println(this.name + " прыгает. Но что-то пошло не так и он падает.");
            this.success = false;
        }
    }
}
