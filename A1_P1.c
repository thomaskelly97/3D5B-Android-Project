#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_BUFFER 101 // Maximum string length this program can handle
int hash1(char *s);
int hashCode(int key);
void searchDisp(char * string);

//MAKING GITHUB CHANGES BLAH 
//Making more CHANGES!!
typedef struct dataItem{
    char key[15];
    int frequency;
}dataItem;

struct dataItem hashArray[MAX_BUFFER];
int add(char* key);

// The CSV parser
int next_field( FILE *f, char *buf, int max ) {
    int i=0, end=0, quoted=0;
    
    for(;;) {
        // fetch the next character from file       
        buf[i] = fgetc(f);
        // if we encounter quotes then flip our state and immediately fetch next char
        if(buf[i]=='"') { quoted=!quoted; buf[i] = fgetc(f); }
        // end of field on comma if we're not inside quotes
        if(buf[i]==',' && !quoted) { break; }
        // end record on newline or end of file
        if(feof(f) || buf[i]=='\n') { end=1; break; }
        // truncate fields that would overflow the buffer
        if( i<max-1 ) { ++i; }
    }

    buf[i] = 0; // null terminate the string
    return end; // flag stating whether or not this is end of the line
}

int main ( int argc, char *argv[] ) {
    FILE *f;        
    char buffer[MAX_BUFFER];
    int col = 0;
	printf("Update github 1");
    for(int i=0;i<MAX_BUFFER;i++){
        hashArray[i].frequency = 0;
        strcpy(hashArray[i].key, "");
    }


	
    // Users must pass the name of the input file through the command line. Make sure
    // that we got an input file. If not, print a message telling the user how to use
    // the program and quit
    if( argc < 2 ) {
        printf("usage: csv FILE\n");
        return EXIT_FAILURE;
    }

    // Try to open the input file. If there is a problem, report failure and quit
    f = fopen(argv[1], "r");
    if(!f) {
        printf("unable to open %s\n", argv[1]);
        return EXIT_FAILURE;
    }

    while( !next_field(f, buffer, MAX_BUFFER) ); // discard the header

    // Now read and print records until the end of the file
    while(!feof(f)) {
        int eor = next_field( f, buffer, MAX_BUFFER );
        //printf("%s%c\n", buffer, ((eor)? '\n':' '));  // double newline if eor is not 0
        col = col + add(buffer); //Counts collisions and adds names to the table
    }
    printf("Collisions: %d\n",col);
    char searchName[15];
    printf("Enter a search name: \n >>");
    scanf("%s", searchName);
    searchDisp(searchName);
    
    // Always remember to close the file
    fclose(f);
    return EXIT_SUCCESS;
}


int hash1(char *s){
    int hash =0;
    while(*s){
			hash= hash+*s;
        s++;
    }
    return hash;
}



int hashCode(int key){
    return key % MAX_BUFFER;
}

int add(char* key){
	//ACTIVATE FOR PART 1 
	int index = hashCode(hash1(key)); //14 Collisions 

	//OPTIMAL choice for size of table is a prime number not too close to a power of 2 
    int collisions = 0, stop=0, s=0;
    while(stop == 0){
        if(hashArray[index].frequency == 0){
            hashArray[index].frequency = 1;
            strcpy(hashArray[index].key,key);
            stop =1;
			s=0;
        } else if(strcmp(key, hashArray[index].key)==0){ //The name is exactly the same as what it's landed on
            hashArray[index].frequency = hashArray[index].frequency + 1; 
            stop =1;
			s=0;
        } else if(s == 0){
            
            collisions = 1;
            stop = 0;
			s=1; 
        }
		index++;
        index%=MAX_BUFFER;
		
    }

    //printf("4\n");
    return collisions;
}

void searchDisp(char * string){
	int flag = 0; // 0 for found, 1 for not found 
    //printf("%s == %s\n %d == %d", string, hashArray[i].key, hash1(string), hash1(hashArray[i].key));
	for(int i =0; i<MAX_BUFFER;i++){
		if(strcmp(string, hashArray[i].key) ==0){
			printf("Name found at index %d with frequency %d.\n", i, hashArray[i].frequency);
			flag = 0; 
			break;
		}  else {
			flag++; 
		}
		if(flag == MAX_BUFFER-1){
			printf("Name not found.\n");
		}
	} 
	
}
