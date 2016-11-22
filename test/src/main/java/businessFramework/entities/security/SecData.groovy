package businessFramework.entities.security

/**
 * Created by bulat.garipov on 20.03.2016.
 */

class SecData implements Cloneable {
    String context
    String templateCode
    String templateName
    String templateType
    String roleName
    String roleType
    String permissionGroup
    String organization
    String department
    String groupName
    String login
    String keyType
    String keyName


    @Override
    public SecData clone() throws CloneNotSupportedException
    {
        return (SecData)super.clone();
    }
}
