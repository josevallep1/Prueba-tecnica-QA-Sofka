package features.signup;

import com.intuit.karate.junit5.Karate;

class SignupRunner {
    
    @Karate.Test
    Karate testSignup() {
        return Karate.run("signup").relativeTo(getClass());
    }    

}
