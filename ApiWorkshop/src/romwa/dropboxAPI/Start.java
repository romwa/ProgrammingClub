package romwa.dropboxAPI;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;
import com.dropbox.core.v2.users.FullAccount;

public class Start {
    private static final String ACCESS_TOKEN = "Vk-C8GdO2lAAAAAAAAAAU-rJIcaqXSwcrbrQKybfMJF_5PKxMbZiCsmQTYK3hdt2";

    public static void main(String args[]) throws DbxException {
        // Create Dropbox client
        DbxRequestConfig config = new DbxRequestConfig("dropbox/java-tutorial", "en_US");
        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);
        
        FullAccount account = client.users().getCurrentAccount();
        System.out.println(account.getName().getDisplayName());
        System.out.println(account.getEmail());
        
        
        ListFolderResult result = client.files().listFolder("");
        while (true) {
            for (Metadata metadata : result.getEntries()) {
                
                if(metadata.getPathLower().equalsIgnoreCase("/" + "apcs 2017-2018")) {
                	System.out.println(metadata.getPathLower() + "/check");
                } else {
                	System.out.println(metadata.getPathLower());
                }
            }
            
            if (!result.getHasMore()) {
                break;
            }

            result = client.files().listFolderContinue(result.getCursor());
        }
    }
}