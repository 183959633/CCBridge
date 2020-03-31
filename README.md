# CCBridge
  cordova-plugin-ccbridge
# use
  npm i cordova-plugin-ccbridge  
      
      declare let cordova: any;    
      @Component({  
        selector: 'app-home',  
        templateUrl: 'home.page.html',  
        styleUrls: ['home.page.scss'],  
      })  
      
  
# 1) method ---- exit()  
#####  exit from application program;  
      exit() {
        cordova.plugins.CCBridge.exit();
      }

# 2) method ---- getAppVersion()  
#####  get app version number;
      export class HomePage {
        versionString: string;
        constructor() {}
        
        getAppVersion() {
          cordova.plugins.CCBridge.getAppVersion((data: string) =>{
            this.versionString = data;
          });
        }
      }
