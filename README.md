# Avaj Launcher

## 📋 Description

**Avaj Launcher** est un projet Java du cursus 42 qui introduit à la programmation orientée objet, aux diagrammes UML et aux design patterns.

Le projet consiste à développer un simulateur minimal d'aéronefs soumis à différentes conditions météorologiques.

## 🎯 Objectifs

- Approfondir la programmation orientée objet en Java
- Utiliser l'héritage et le polymorphisme
- Implémenter les design patterns **Observer**, **Singleton** et **Factory**
- Manipuler et valider des fichiers de scénario
- Concevoir une architecture à partir d'un diagramme UML

## 🛠️ Prérequis

Aucune bibliothèque externe n'est nécessaire.

- Java
- javac

Vérification :

```bash
java --version
javac --version
```

## 📁 Structure

```bash
avaj-launcher/
├── avaj/
│   ├── aircraft/
│   ├── simulator/
│   └── tower/
├── global.puml
├── avaj_uml.png
├── scenario.txt
└── README.md
```

## ✈️ Simulation

Trois types d'aéronefs sont disponibles :

- 🎈 `Balloon`
- 🚁 `Helicopter`
- ✈️ `JetPlane`

Chaque aéronef possède un identifiant unique, un nom et des coordonnées en trois dimensions.

La simulation utilise quatre conditions météorologiques :
- `SUN`
- `RAIN`
- `FOG`
- `SNOW`

Chaque type d'aéronef réagit différemment aux changements de météo.

L'altitude est limitée entre `0` et `100`. Lorsqu'un aéronef atteint `0`, il atterrit et est désinscrit de la `WeatherTower`.

## 🏗️ Architecture

Le projet est organisé en trois packages :

```bash
aircraft/
simulator/
tower/
```

La communication entre la `WeatherTower` et les aéronefs repose sur le pattern **Observer** : les aéronefs enregistrés sont automatiquement informés lorsqu'un changement météorologique survient.

La création des aéronefs est centralisée dans `AircraftFactory`, qui utilise le pattern **Factory** pour créer le bon type d'aéronef à partir du scénario.

`AircraftFactory` et `WeatherProvider` utilisent le pattern **Singleton** afin de garantir une instance unique de chacun de ces composants.

## 📄 Scénario

Le programme prend exactement un argument : le fichier de scénario.

Format :
```bash
NUMBER_OF_SIMULATIONS
TYPE NAME LONGITUDE LATITUDE HEIGHT
TYPE NAME LONGITUDE LATITUDE HEIGHT
...
```

Exemple :
```bash
5
Balloon B1 10 10 50
JetPlane J1 20 20 50
Helicopter H1 30 30 50
```
Les entrées sont validées avant le lancement de la simulation.

## 🔨 Compilation

Depuis la racine du projet :
 ```bash
 find * -name "*.java" > sources.txt
javac @sources.txt
 ```

## ▶️ Exécution
```bash
java -cp avaj simulator.Simulator scenario.txt
```

Le résultat est écrit dans :

```text
simulation.txt
```

## 📐 UML

Le diagramme UML est disponible dans :

```text
global.puml
avaj_uml.png
```

## 👤 Auteur
**Camille Gorin** aka **cgorin** — 42 Nice