import java.util.*;

public class Meeting {

    private int startTime;
    private int endTime;

    public Meeting(int startTime, int endTime){
        // number of 30 min blocks past 9:00am
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime( int startTime ) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime( int endTime ) {
        this.endTime = endTime;
    }


    public boolean mergeableWith( Meeting anotherMeeting ){

        //find out the order of the two meetings
        Meeting earlierMeet = this.getStartTime() < anotherMeeting.getStartTime() ? this : anotherMeeting;
        Meeting laterMeet = earlierMeet == this ? anotherMeeting : this;

        return earlierMeet.getEndTime() >= laterMeet.getStartTime();

    };

    public static Meeting mergeTwoMeetings( Meeting meetOne, Meeting meetTwo ) throws Exception {

        //find out the order of the two meetings
        Meeting earlierMeet = meetOne.getStartTime() < meetTwo.getStartTime() ? meetOne : meetTwo;
        Meeting laterMeet = earlierMeet == meetOne ? meetTwo : meetOne;

        if( earlierMeet.mergeableWith(laterMeet)){
           return new Meeting( earlierMeet.getStartTime(), laterMeet.getEndTime() );
        } else {
            throw new Exception("Meetings are not mergeable!");
        }
    }


    public static Meeting[] merge( Meeting meetings[] ) throws Exception {

        List<Meeting> sortedMeetings = new ArrayList<>();
        Collections.addAll(sortedMeetings, meetings);
        Collections.sort( sortedMeetings, Comparator.comparingInt(Meeting::getStartTime));

        List<Meeting> mergedMeetings = new ArrayList<Meeting>();

        Meeting previousMeeting = sortedMeetings.get(0);

        for(int idx = 1; idx < sortedMeetings.size(); idx++){

            Meeting currentMeeting = sortedMeetings.get(idx);

            if(previousMeeting.mergeableWith(currentMeeting)){

                Meeting mergedMeeting = Meeting.mergeTwoMeetings(previousMeeting, currentMeeting);
                mergedMeetings.add(mergedMeeting);
                previousMeeting = mergedMeeting;

            } else if (idx != sortedMeetings.size() - 1){
                if(!mergedMeetings.contains(previousMeeting))
                    mergedMeetings.add(previousMeeting);
                previousMeeting = currentMeeting;
            } else {
                if(!mergedMeetings.contains(previousMeeting))
                    mergedMeetings.add(previousMeeting);
                mergedMeetings.add(currentMeeting);
            }
        }

        return mergedMeetings.toArray(new Meeting[0]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Meeting)) return false;
        Meeting meeting = (Meeting) o;
        return startTime == meeting.startTime && endTime == meeting.endTime;
    }

}
