package businessFramework.module.security.group;

import businessFramework.module.Values;

/*
 /* @author enuzhdina 
 /* @since 12.01.2016
 */
public interface GroupValues extends Values {
    String container_id = "groups";
    String org_id = "org";
    String name_id = "name";

    String name_column = "Наименование";
    String org_column = "МО";
}
