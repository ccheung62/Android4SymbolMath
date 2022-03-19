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

* User logs in to access their study record
* User picks the diffculity they want
* A page that generates question based on their preference
* Profile page for each user
* Settings (diffculity settings)

Optional Nice-to-have Stories

* [fill in your required user stories here]
* ...

### 2. Screen Archetypes

* Login
* Register
   * Upon Download/Reopening of the appliation, the user is asked to login or register 
   * their information would be logged in a database for future reference
* Home screen where User can start practicing or look upon their past practice history.
* Diffuculty
   * User chooses their desired difficulty for what they are practicing
* Practice
    * Area to practice

### 3. Navigation

Tab Navigation (Tab to Screen)

* Login/Register
* Home Feed
* Profile

Flow Navigation (Screen to Screen)

* Forced Log-in -> Account creation if no log in is available
* Home Feed -> Selection of difficulty and area to practice
* Profile -> Display their history of practice problems
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
   | Difficulty    | String   | idenify the diffculity of the problems generated |
   | History       | Array of Strings | history of the problems that the user has completed |
### Networking
- Home Feed Screen
    - (READ/GET) The users original difficulty and other preferences
- Practice Screen
    - (READ/GET) Problems based on the user's setting
- Profile Screen
    - (Update/PUT) Update various preferences
    - (READ/GET) Problems that they had favorited
- [Create basic snippets for each Parse network request]
- [OPTIONAL: List endpoints if using existing API such as Yelp]
