package in.reqres.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:person.properties")
public interface PersonConfig extends Config{
    @Key("CREATE_NAME")
    String createName();

    @Key("CREATE_JOB")
    String createJob();

    @Key("UPDATE_NAME")
    String updateName();

    @Key("UPDATE_JOB")
    String updateJob();

    @Key("ONE_MORE_UPDATE_NAME")
    String oneMoreUpdateName();

    @Key("ONE_MORE_UPDATE_JOB")
    String oneMoreUpdateJob();
}
