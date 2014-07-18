/*****************************
        Author: Christian Miller
        Date: 4/10/2014
        Program Specifications: Chat Server and Client similar to previous programming assignment, except that it is multithreaded accepting any amount of inputs from
        both the client and server without having to stop and wait for a reply.
*****************************/

import java.io.*;
import java.net.*;

class FlagObject{
        private boolean flag;

        public FlagObject(){
                this.flag = true;
        }//flagObject

        public boolean getFlag(){
                return this.flag;
        }//getFlag

        public void setFalse(){
                this.flag = false;
        }//setFalse
}//FlabObject
