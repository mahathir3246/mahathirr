#define _POSIX_C_SOURCE 200809L
#include "project.h"
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>
#include <ctype.h>
Character *add_character(Character **listofcharacters, int *size, const char *name, int hitpoints, const char *weapon_name, int weapon_damage)
{
    // Check if character already exists
    if (*size != 0)
    {
        for (int i = 0; i < *size; i++)
        {
            if (strcmp((*listofcharacters)[i].name, name) == 0)
            {
                printf("Fighter \"%s\" is already in the database.\n", name);
                return NULL;
            }
        }
    }

    // reallocating list for new characters to aadd
    Character *newlist = realloc(*listofcharacters, (*size + 1) * sizeof(Character));
    if (newlist == NULL)
    {
        printf("Invalid command: Error allocating memory.\n");
        return NULL;
    }

    //making the new character
    Character *newcharacter = &newlist[*size];
    newcharacter->name = strdup(name);
    newcharacter->HP = hitpoints;
    newcharacter->experience = 0;
    newcharacter->firearm.weapon_name = strdup(weapon_name);
    newcharacter->firearm.damage = weapon_damage;
    *size += 1;
    *listofcharacters = newlist;
    return newcharacter;
}

//compare function for qsort this function puts dead characters at the end and also if some characters have the same experience then puts them in a descending alphabetical ordering
int compareCharacters(const void *a, const void *b)
{
    const Character *characterA = (const Character *)a;
    const Character *characterB = (const Character *)b;

    // Characters with 0 HP always go to the end
    if (characterA->HP == 0 && characterB->HP != 0) {
        return 1; // A goes after B
    }
    if (characterB->HP == 0 && characterA->HP != 0) {
        return -1; // A goes before B
    }

    // Compare by experience, descending
    if (characterB->experience != characterA->experience) {
        return characterB->experience - characterA->experience;
    }

    // If experiences are the same, sort alphabetically by name
    return strcmp(characterA->name, characterB->name);
}



//compare function if we want to just put the dead players at the end and in a descending order by expeirence (alphabetical order not included)
/*
int compareCharacters(const void *a, const void *b)
{
    const Character *characterA = (const Character *)a;
    const Character *characterB = (const Character *)b;

    // Characters with 0 HP always go to the end
    if (characterA->HP == 0 && characterB->HP != 0) {
        return 1; // A goes after B
    }
    if (characterB->HP == 0 && characterA->HP != 0) {
        return -1; // A goes before B
    }

    // Compare by experience, descending
    return characterB->experience - characterA->experience;

}

*/

// printing the characters
void print_characters(Character *list, int size)
{
    if (size == 0)
    {
        printf("No characters to display yet.\n");
        return;
    }
    qsort(list, size, sizeof(Character), compareCharacters); // Sorts using the improved comparison function

    for (int i = 0; i < size; i++)
    {
        printf("%s %d %d %s %d\n", list[i].name, list[i].HP, list[i].experience, list[i].firearm.weapon_name, list[i].firearm.damage);
    }
    printf("SUCCESS\n");
}


// this function is to check that the names of the characters is a string like "Bill" or "Bill22" but not only numbers like "22" 

int is_valid_name(const char *str)
{
    int has_alpha = 0; // Flag to check if there's at least one alphabetic character
    for (int i = 0; str[i] != '\0'; i++)
    {
        if (!isalnum(str[i]))
        {             // Check if the character is not alphanumeric
            return 0; // Invalid character found (neither letter nor number)
        }
        if (isalpha(str[i]))
        {
            has_alpha = 1; // At least one alphabetic character found
        }
    }
    return has_alpha; // Ensure at least one alphabetic character is in the name
}



int attack(Character **characterList, int *size, const char *attackerName, const char *targetName)
{
    Character *attacker = NULL;
    Character *target = NULL;

    // Find both the attacker and target in the list
    for (int i = 0; i < *size; i++)
    {
        if (strcmp((*characterList)[i].name, attackerName) == 0)
        {
            attacker = &(*characterList)[i];
        }
        if (strcmp((*characterList)[i].name, targetName) == 0)
        {
            target = &(*characterList)[i];
        }
    }
    // Verify both characters were found

    if (attacker == NULL || target == NULL)
    {
        printf("Invalid command: One or both of the specified characters do not exist.\n");
        return 0;
    }

// if attacker is already dead 
    if (attacker->HP == 0)
    {
        printf("Attacker \"%s\" is already dead\n", attackerName);
        return 0;
    }

// if attacker tries to attack itself
    if (strcmp(attacker->name, target->name) == 0)
    {
        printf("Attacker \"%s\" cannot attack to itself.\n", attackerName);
        return 0;
    }

    
    // if target is dead
    if (target->HP == 0)
    {
        printf("Target \"%s\" is already dead\n", targetName);
        return 0;
    }
    // Check if the attack is allowable based on target's current hit points or if the attack will kill the target
    if (target->HP < attacker->firearm.damage)
    {
        attacker->experience += attacker->firearm.damage;
        target->HP = 0;
        printf("%s attacked %s with %s by %d damage.\n%s has %d hit points remaining.\n",
               attackerName, targetName, attacker->firearm.weapon_name, attacker->firearm.damage, targetName, target->HP);
        printf("%s gained %d experience points.\nSUCCESS\n", attackerName, attacker->firearm.damage);

        return 1;
    }
    // Perform the attack if allowable
    target->HP -= attacker->firearm.damage;
    attacker->experience += attacker->firearm.damage;
    printf("%s attacked %s with %s by %d damage.\n%s has %d hit points remaining.\n",
           attackerName, targetName, attacker->firearm.weapon_name, attacker->firearm.damage, targetName, target->HP);
    printf("%s gained %d experience points. \nSUCCESS\n", attackerName, attacker->firearm.damage);
    return 1; // Success
}



int saveToFile(Character *characterlist, int *size, char *filename)
{
    //opening the file to write
    FILE *f = fopen(filename, "w");
    if (!f)
    {
        printf("Invalid command: Error occured while opening the file\n");
        return 0;
    }

    for (int i = 0; i < *size; i++)
    {
        fprintf(f, "%s %d %d %s %d\n", characterlist[i].name, characterlist[i].HP, characterlist[i].experience, characterlist[i].firearm.weapon_name, characterlist[i].firearm.damage);
        // printing in the format (list[i].name, list[i].HP, list[i].experience, list[i].firearm.weapon_name, list[i].firearm.damage);
    }
    fclose(f);
    return 1;
}
int loadFromFile(Character **characters, int *size, const char *filename)
{

    //open the file to read
    FILE *f = fopen(filename, "r");
    if (!f)
    {
        printf("Invalid command: Error occurred while opening the file '%s'\n", filename);
        return 0; // Indicate failure to open file
    }
    // Prepare to read file contents
    char line[256];
    char name[100], weaponName[100];
    int hitpoints, experience, weaponDamage;
    // Free current characters if necessary
    for (int i = 0; i < *size; i++)
    {
        free((*characters)[i].name);
        free((*characters)[i].firearm.weapon_name);
    }
    free(*characters);
    *characters = NULL;
    *size = 0;
    while (fgets(line, sizeof(line), f) != NULL)
    {
        if (sscanf(line, "%99s %d %d %99s %d", name, &hitpoints, &experience, weaponName, &weaponDamage) == 5)
        {
            Character *newCharacter = add_character(characters, size, name, hitpoints, weaponName, weaponDamage);
            if (newCharacter)
            {
                newCharacter->experience = experience; // Set experience explicitly after adding
            }
            else
            {
                printf("Invalid command: Failed to add character from file: %s\n", name);
                // Continue attempting to load other characters
            }
        }
        else
        {
            printf("Invalid command: Error parsing line: %s\n", line);
        }
    }
    fclose(f); // Close the file after reading
    return 1;  // Indicate success
}
int main()
{
    Character *characters = NULL;
    int character_count = 0;
    char line[256]; // Buffer for reading the whole command line
    while (1)
    {
        if (!fgets(line, sizeof(line), stdin))
        {
            printf("Invalid command: Error reading input.\n");
            continue;
        }
        char command;
        char name[100];
        int hitpoints;
        char weapon_name[100];
        int weapon_damage;
        char attackername[100];
        char targetname[100];
        char filename[100];
        if (sscanf(line, "%c", &command) < 1)
        {
            printf("Invalid command format.\n");
            continue;
        }
        if (command == 'Q')
        {
            printf("SUCCESS.\n");
            break; // Exit loop if the command is Q
        }
        else if (command == 'A')
        {
            if (sscanf(line + 2, "%99s %d %99s %d", name, &hitpoints, weapon_name, &weapon_damage) == 4)
            {
                if (!is_valid_name(name))
                {
                    printf("Invalid command: The name of the characters should only have letters eg. BILL or letters and numbers eg. BILL253\n");
                    continue;
                }
                else if (!is_valid_name(weapon_name))
                {
                    printf("Invalid command: The name of the weapon should only have letters eg. Rifle or letters and numbers eg. AK-47\n");
                    continue;
                }
                else if (hitpoints <= 0)
                {
                    printf("Invalid command: Hitpoints must be greater than 0.\n");
                    continue;
                }
                else if (weapon_damage <= 0)
                {
                    printf("Invalid command:Weapon damage must be greater than 0.\n");
                    continue;
                }
                else
                {
                    Character *character = add_character(&characters, &character_count, name, hitpoints, weapon_name, weapon_damage);
                    if (character != NULL)
                    {
                        printf("SUCCESS\n");
                    }
                }
            }
            else
            {
                printf("Invalid command for adding a character. Please provide full details: A <name> <hit-points> <weapon-name> <weapon-damage>.\n");
            }
        }
        else if (command == 'L')
        {
            print_characters(characters, character_count); // List all characters
        }
        else if (command == 'H')
        {
            if (sscanf(line + 2, "%99s %99s", attackername, targetname) == 2)
            {
                attack(&characters, &character_count, attackername, targetname);//use the attack function to attack
            }
            else
            {
                printf("Invalid command for attacking a character. Please provide full details: H <attacker-name> <target-name>.\n");
            }
        }
        else if (command == 'W')
        {
            if (sscanf(line + 2, "%99s", filename) == 1)
            {
                if (saveToFile(characters, &character_count, filename))// save inof to the file
                {
                    printf("SUCCESS\n");
                }
                else
                {
                    printf("Invalid command: Failed to save data to '%s'.\n", filename);
                }
            }
            else
            {
                printf("Invalid command for saving data. Please provide a filename: W <filename>.\n");
            }
        }
        else if (command == 'O')
        {
            if (sscanf(line + 2, "%99s", filename) == 1)
            {
                if (loadFromFile(&characters, &character_count, filename))// Load from the file
                { // Pass addresses of characters and character_count
                    printf("SUCCESS\n");
                }
                else
                {
                    printf("Invalid command for loading data. Please provide a filename: O <filename>.\n");
                }
            }
        }
        else
        {
            printf("Invalid command: The command '%c' is unknown.\n", command);
        }
    }
    // Clean up
    for (int i = 0; i < character_count; i++)
    {
        free(characters[i].name);
        free(characters[i].firearm.weapon_name);
    }
    free(characters);
    return 0;
}