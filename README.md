# 🧪 Atelier - Création d’un UserService REST avec Spring Boot

Ce projet est une introduction pratique à la création d’un microservice REST avec **Spring Boot**, dans le cadre du module _Microservices_ du parcours 4AMS.

## 🎯 Objectifs pédagogiques

- Comprendre les concepts fondamentaux d’un service REST
- Implémenter un contrôleur REST en Java avec Spring Boot
- Manipuler des objets `record` en Java
- Tester des endpoints REST (GET, POST)

---

## 🏗️ Stack utilisée

- Java 17+
- Spring Boot
  - Spring Web
  - Lombok
- Maven (wrapper `./mvnw` fourni)
- Outils de test : Navigateur, Postman

---

## 🛠️ Étapes du projet

### 1. Créer un projet Spring Boot avec les dépendances :

- Spring Web
- Lombok

### 2. Créer un modèle `User` :

```java
public record User(int id, String name) {}
```

> ✅ Grâce au `record`, on a une classe immuable prête à l’emploi (constructeur, getters, `toString`, `equals`, `hashCode` générés automatiquement).

### 3. Implémenter un contrôleur `UserController` :

```java
@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public List<User> getAllUsers() {
        return List.of(
            new User(1, "Alice"),
            new User(2, "Bob")
        );
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return new User(id, "User" + id);
    }

    @PostMapping
    public String createUser(@RequestBody User user) {
        return "User " + user.name() + " created!";
    }
}
```

---

## ▶️ Lancer et tester l'application

```bash
./mvnw spring-boot:run
```

### Tester les endpoints :

- `GET /users` → retourne une liste statique d’utilisateurs
- `GET /users/2` → retourne l’utilisateur avec l’id 2
- `POST /users` avec un JSON comme `{ "id": 3, "name": "Charlie" }` → confirmation de création

---

## ❓ Questions fréquentes

**1. Qu’est-ce qu’un contrôleur REST ?**  
Un contrôleur REST est une classe Java annotée avec `@RestController` qui gère les requêtes HTTP et retourne des objets (JSON).

**2. À quoi sert l’annotation `@RequestBody` ?**  
Elle convertit automatiquement un JSON reçu en un objet Java.

**3. Différences entre `@GetMapping` et `@PostMapping` ?**

- `GET` : pour lire des données
- `POST` : pour créer de nouvelles ressources

**4. Comment récupérer un paramètre d’URL ?**  
Avec `@PathVariable`, par exemple `/users/{id}`.

---

## 🎉 Félicitations !

Tu viens de créer un **UserService REST** complet avec Spring Boot 🚀  
N’hésite pas à aller plus loin avec une base de données ou une couche service !

---

## 👨‍🏫 Auteur

Yassen ABARJI  
Module 4AMS – Microservices – Jour 1  
📅 24/04/2025
