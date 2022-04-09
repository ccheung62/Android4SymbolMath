# 4SymbolMath

## Table of Contents
1. [Overview](#Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)
2. [Schema](#Schema)

## Overview
### Description
An android app for students and teachers to practice simple math.

### App Evaluation
[Evaluation of your app across the following attributes]
- Category: Education
- Mobile: This app would be developed for mobile but could also be used for computer with similar functionality
- Story: Generates practice problems for students to improve their binomial algebra skill individually
- Market: Students who are struggling with binomial algebra 
- Habit: This app could be used whenever the user wants as well as during test prep or tutoring
- Scope: We could start with a small tutoring group or class, then broaden the audience to the school and other curriculum

## Product Spec

### 1. User Stories (Required and Optional)

Required Must-have Stories

* [x] User logs in to access their study record 
* [x] User can access there record
    * View favorited problems / all previous attempted problems 
* [x] User picks the diffculity they want 
* [x] A page that generates question based on their preference 
* [x] Settings 
    * daily goals
    * changing username/ password

Optional Nice-to-have Stories

* [x] Progress bar to track how much problem the user have complete
    * Flexible max number that can be changed in settings
* [x] Ability to log out

### 2. Screen Archetypes

* Login
* Register
   * Upon Download/Reopening of the appliation, the user is asked to login or register 
   * their information would be logged in a database for future reference
* Home screen where User look upon their past practice history.
* Diffuculty
   * User chooses their desired difficulty for what they are practicing
* Practice
    * Area to practice

### 3. Navigation

Tab Navigation (Tab to Screen)

* Login/Register
* Home Feed
* Setting
* Generate
* Favorite Feed

Flow Navigation (Screen to Screen)

* Forced Log-in -> Account creation if no log in is available
* Home Feed -> See previous attempt question and how much question was completed already
* Generate -> Choose difficulty and operation 
* Problem Display -> Area where user can practice and favorite those problems
* Favorite Feed -> Display their favorite practice problems
* Settings -> Change their preferences

## Wireframes
[Add picture of your hand sketched wireframes in this section]
<img src="https://github.com/Codepath-Android-2022-Group-1/Android4SymbolMath/blob/main/wireframe.jpg" width=600>

### [BONUS] Digital Wireframes & Mockups

### [BONUS] Interactive Prototype

## Schema 

### Models
   | Property      | Type     | Description |
   | ------------- | -------- | ------------|
   | userId        | String   | unique id for each user |
   | Goal          | Number   | identity the number of question the user wants to complete |
   | CurrentNum    | Number   | tracks the number of question the user have finished |
   | Problem       | Object   | tracks the problem itself and whether it is favorited |

### Networking
- Home Feed Screen
    - (READ/GET) The users previous attempted question 
    ```
    // Specify which class to query
        val query: ParseQuery<Problem> = ParseQuery.getQuery(Problem::class.java)
        query.include(Problem.KEY_USER)
        query.whereEqualTo(Problem.KEY_USER, ParseUser.getCurrentUser())
        // Return problem in descending order
        query.addDescendingOrder("createdAt")
        query.setLimit(20)

        // Find all Problem
        query.findInBackground(object : FindCallback<Problem> {
            override fun done(problems: MutableList<Problem>?, e: ParseException?) {
                if (e != null) {
                    Log.e(TAG, "Error fetching problems")
                } else if (problems != null) {
                    adapter.clear()
                    allProblems.addAll(problems)
                    adapter.notifyDataSetChanged()
                }
            }
        })
    ```
    - (READ/GET) The user goal and current number of question completed
    ```
        var progressNum = user.get("goal")
        var currentNum = user.get("currentQuestion")
    ```
- Setting Screen
    - (Update/PUT) Update username/ password
    ```
        val username = view.findViewById<EditText>(R.id.etChangeUsername).text.toString()
        user.username = username
        user.saveInBackground()
    ```
    - (Update/PUT) Update the user's goal
    ```
        user.put("goal", goalNum)
        user.saveInBackground()
    ```
- Favorite Screen 
    - (READ/GET) The problems the user favorited
    ```
        // Specify which class to query
        val query: ParseQuery<Problem> = ParseQuery.getQuery(Problem::class.java)
        query.include(Problem.KEY_USER)
        query.whereEqualTo(Problem.KEY_USER, ParseUser.getCurrentUser())
        query.whereEqualTo(Problem.KEY_FAVE, true)
        // Return problem in descending order
        query.addDescendingOrder("createdAt")
        query.setLimit(20)

        // Find all Problem
        query.findInBackground(object : FindCallback<Problem> {
            override fun done(problems: MutableList<Problem>?, e: ParseException?) {
                if (e != null) {
                    Log.e(TAG, "Error fetching problems")
                } else if (problems != null) {
                    adapter.clear()
                    allFavorite.addAll(problems)
                    adapter.notifyDataSetChanged()
                }
            }
        })
    ```
