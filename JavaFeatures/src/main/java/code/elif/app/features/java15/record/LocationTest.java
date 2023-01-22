package code.elif.app.features.java15;

public class LocationTest {

    public static void main(String[] args) {
        LocationRecord locationRecordOne = new LocationRecord("Turkey", 41.2937, 29.9629);
        LocationRecord locationRecordTwo = new LocationRecord("Turkey", 41.2937, 29.9629);

        System.out.println("Same location: " + locationRecordOne.equals(locationRecordTwo));
        System.out.println("Latitude: " + locationRecordOne.latitude());
        System.out.println("Longitude :" + locationRecordOne.longitude());
        System.out.println(locationRecordOne);

    }
}