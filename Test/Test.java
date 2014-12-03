import com.google.common.collect.*;
import java.util.*;

/**
 * This a test.
 */
public class Test
{
    /**
     * Represents a student.  This class is immutable.
     */
    public static class Undergraduate
    {
        /** The name of the undergraduate. */
        public final String name;

        /** The student's ID number. */
        public final int ID;

        /** This undergraduate's friends. */
        public final List<Undergraduate> friends;

        /**
         * Creates a student.
         * @param name the name of the student
         * @param ID the ID of the student
         * @param friends the friends of this student
         */
        public Undergraduate(String name, int ID, List<Undergraduate> friends)
        {
            if ( name == null )
                throw new NullPointerException("student must have a name");
            this.name = name;
            this.ID = ID;
            if ( friends == null )
                this.friends = ImmutableList.of();
            else
                this.friends = ImmutableList.copyOf(friends);
        }

        /**
         * Adds a friend for this undergraduate.
         * @param undergraduate the person to make friends with
         * @return a new undergraduate that is friends with the specified person
         */
        public Undergraduate addFriend(Undergraduate undergraduate)
        {
            List<Undergraduate> newFriends = new ArrayList<>(friends);
            newFriends.add(undergraduate);
            return new Undergraduate(name, ID, newFriends);
        }

        @Override
        public int hashCode()
        {
            return Objects.hash(name,ID,friends);
        }

        @Override
        public boolean equals(Object obj)
        {
            if ( obj == null )
                return false;
            if ( obj == this )
                return true;
            if ( !(obj instanceof Undergraduate) )
                return false;

            Undergraduate u = (Undergraduate)obj;
            if ( Objects.equals(name, u.name) &&
                ID == u.ID &&
                 Objects.equals(friends, u.friends) )
                return true;
            return false;
        }

        @Override
        public String toString()
        {
            return String.format("%s (%s) Friends: %s", name, ID, friends.toString());
        }
    }

    /** For testing. */
    public static void main(String[] args)
    {
        // make a richard
        Undergraduate richard = new Undergraduate("Richard", 123, null);
        System.out.println(richard);

        // make a bob
        Undergraduate bob = new Undergraduate("Bob", 456, null);
        
        // richard makes friends
        richard = richard.addFriend(bob);
        System.out.println(richard);

        // test equal
        Undergraduate richardClone = new Undergraduate("Richard", 123, ImmutableList.of(bob));

        System.out.println(richard.equals(bob));
        System.out.println(richard.equals(richardClone));
    }
}
