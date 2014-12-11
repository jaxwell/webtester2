package net.bykov;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Ievgen on 11/30/2014.
 */
public interface ApplicationConstants {
    int ADMIN_ROLE 			= 1;
    int ADVANCED_TUTOR_ROLE = 2;
    int TUTOR_ROLE 			= 3;
    int STUDENT_ROLE 		= 4;
    List<Integer> ROLES = Arrays.asList(new Integer[]{ADMIN_ROLE, ADVANCED_TUTOR_ROLE, TUTOR_ROLE, STUDENT_ROLE});
}

