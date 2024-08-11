#ifndef _PROJECT__H_
#define _PROJECT__H_
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct
{
    char *weapon_name;
    int damage;
} Weapon;

typedef struct
{
    char *name;
    int HP;
    int experience;
    Weapon firearm;
} Character;

Character *add_character(Character **listofcharacters, int *size, const char *name, int hitpoints, const char *weapon_name, int weapon_damage);
int comparefunctionforqsort(const void *a, const void *b);
void print_characters(Character *list, int size);
int is_valid_name(const char *str);
int attack(Character **characterList, int *size, const char *attackerName, const char *targetName);
int saveToFile(Character *characterlist, int *size, char *filename);
int loadFromFile(Character **characters, int *size, const char *filename);

#endif //! _PROJECT__H_