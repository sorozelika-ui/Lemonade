# 🍋 Lemonade

## 📱 Présentation

**Lemonade** est une application Android développée avec **Kotlin** et **Jetpack Compose**.

L'application permet à l'utilisateur de suivre les différentes étapes de préparation et de consommation d'une limonade à travers une interface interactive.

---

## 🎯 Objectif du projet

Ce projet a pour objectif de mettre en pratique plusieurs notions de développement Android avec **Jetpack Compose**, notamment :

* La création d'interfaces avec des composables.
* La gestion des états avec `remember` et `mutableStateOf`.
* L'utilisation de `Modifier`.
* La gestion des clics avec `Modifier.clickable`.
* L'utilisation des images avec `Image`.
* L'utilisation des ressources `drawable` et `string`.
* La modification dynamique de l'interface selon l'état de l'application.

---

## 🍋 Fonctionnement de l'application

L'application comporte quatre étapes.

### 1. Sélection du citronnier 🌳

L'utilisateur voit l'image du citronnier avec le texte :

**"Tap the lemon tree to select a lemon"**

En cliquant sur le citronnier, l'application passe à l'étape suivante.

### 2. Presser le citron 🍋

L'utilisateur voit un citron avec le texte :

**"Keep tapping the lemon to squeeze it"**

L'utilisateur clique sur le citron afin de poursuivre le processus.

### 3. Boire la limonade 🥤

L'utilisateur voit un verre de limonade avec le texte :

**"Tap the lemonade to drink it"**

Un clic permet de passer à l'étape suivante.

### 4. Recommencer 🫗

L'utilisateur voit un verre vide avec le texte :

**"Tap the empty glass to start again"**

Un clic permet de recommencer le processus depuis le début.

---

## 🎨 Interface utilisateur

Un titre **"Lemonade"** a été ajouté en haut de l'application.

Le titre est placé dans un rectangle jaune et reste fixe lorsque les images changent.

Le texte d'instruction situé sous l'image est également centré afin d'améliorer la présentation de l'application.

---

## 🛠️ Technologies utilisées

* **Kotlin**
* **Android Studio**
* **Jetpack Compose**
* **Material 3**
* **Android SDK**

---

## 📂 Ressources utilisées

Les différentes étapes utilisent quatre images :

```text
lemon_tree
lemon_squeeze
lemon_drink
lemon_restart
```

Les textes de l'application sont stockés dans le fichier `strings.xml`.

---

# ⚠️ Difficultés rencontrées et solutions

## 1. Les quatre images n'apparaissaient pas dans le Preview

Au début du développement, seule l'image du citronnier apparaissait dans le Preview.

### Solution

J'ai utilisé une variable d'état `level` afin de contrôler l'image affichée :

```kotlin
val imageResource = when (level) {
    1 -> R.drawable.lemon_tree
    2 -> R.drawable.lemon_squeeze
    3 -> R.drawable.lemon_drink
    else -> R.drawable.lemon_restart
}
```

Cela permet à l'application de changer d'image lorsque la valeur de `level` change.

---

## 2. Le texte d'instruction n'était pas correctement positionné

Le texte **"Tap the lemon tree to select a lemon"** apparaissait initialement trop bas par rapport à l'image.

### Solution

J'ai utilisé une `Column` et un `Spacer` afin de mieux organiser l'image et le texte :

```kotlin
Spacer(
    modifier = Modifier.height(16.dp)
)
```

J'ai également utilisé :

```kotlin
textAlign = TextAlign.Center
```

afin de centrer le texte.

---

## 3. Le titre "Lemonade" devait rester fixe

Une difficulté est apparue lorsque j'ai ajouté le titre en haut de l'écran.

L'image pouvait remonter dans la zone du titre lorsque les différentes étapes de l'application changeaient.

### Solution

Le problème venait de l'organisation des `Column`.

J'ai placé le titre dans un `Box` situé en haut de la `Column` principale et placé le contenu dynamique dans une deuxième `Column`.

J'ai également utilisé :

```kotlin
.weight(1f)
```

pour que le contenu dynamique occupe uniquement l'espace situé sous le titre.

---

## 4. Le titre devait être présenté dans un rectangle jaune

Je voulais que le titre soit clairement visible en haut de l'application.

### Solution

J'ai utilisé un `Box` avec un arrière-plan jaune :

```kotlin
Box(
    modifier = Modifier
        .fillMaxWidth()
        .background(Color.Yellow)
        .padding(vertical = 16.dp),
    contentAlignment = Alignment.Center
)
```

Le texte est ainsi centré horizontalement et verticalement dans le rectangle.

---

## 5. Le nombre de clics sur le citron

Une autre difficulté concernait le comportement du citron.

Le code initial comptait les clics avec :

```kotlin
var nbclic by remember { mutableStateOf(0) }
```

Puis l'application attendait quatre clics :

```kotlin
if (nbclic >= 4) {
    level = 3
}
```

J'ai compris que `clickable` permet simplement de détecter le clic et que c'est la logique présente dans le `when` qui détermine le nombre de clics nécessaires.

---

## 📚 Ce que j'ai appris

Grâce à ce projet, j'ai appris à :

* Utiliser les fonctions `@Composable`.
* Gérer l'état d'une application avec `remember` et `mutableStateOf`.
* Utiliser `when` pour modifier le contenu de l'interface.
* Rendre une image interactive avec `Modifier.clickable`.
* Organiser une interface avec `Column`, `Box` et `Spacer`.
* Positionner et centrer correctement les éléments.
* Utiliser les ressources Android (`drawable` et `string`).
* Identifier et corriger des problèmes d'affichage dans le Preview et l'émulateur.

---

## 🚀 Installation et exécution

1. Ouvrir le projet dans **Android Studio**.
2. Synchroniser le projet avec Gradle.
3. Démarrer un émulateur Android ou connecter un appareil Android.
4. Cliquer sur **Run ▶**.
5. Sélectionner l'application **Limonade**.

---

## 👩‍💻 Auteur

**Zelika Soro**

Projet réalisé dans le cadre de l'apprentissage du développement d'applications Android avec **Kotlin et Jetpack Compose**.
