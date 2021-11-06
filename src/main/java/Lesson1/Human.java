package Lesson1;

public class Human implements Participant {
    private String name;
    private int runningDistance;
    private int jumpHeight;
    private boolean success = true;

    public Human(String name, int runningDistance, int jumpHeight) {
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
        System.out.println(this.name + " делает бег на месте. Общепримиряющий");
    }

    public void running(RunningTrack rt){
        if(success == false) return;
        if (rt.getDistance() <= runningDistance){
            System.out.println(this.name + " побежал.");
            this.runningDistance -= rt.getDistance();
        }else {
            System.out.println(this.name + " выдохся и не добежал.");
            this.success = false;
        }
    }

    public void jumping(){ System.out.println(this.name + " разминается прыжками.");   }
    public void jumping(JumpingWall jw){
        if(success == false) return;
        if (jw.getHeight() <= jumpHeight){
            System.out.println(this.name + " ловкими движениями перемахнул через стену.");
        }else {
            System.out.println(this.name + " не смог перепрыгнуть стену.");
            this.success = false;
        }
    }
}
