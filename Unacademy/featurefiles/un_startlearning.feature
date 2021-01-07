#Author:

@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
 Scenario: Verify Start Learning Button

   Given user opens unacademy url
   When select start learning
   Then display exam module page
   
   @tag2
   Scenario: Verify Exam Module Page

   Given user is on exam module page
   When user selects an exam
   Then display courses offered
   
   
   @tag3
    Scenario: Verify Courses offered

    Given user is on exam module page
    When user selects a course
    Then displays subscription page

     