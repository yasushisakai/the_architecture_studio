## Definition of elements

### Studio (W)
A ```Studio``` is a class taken by a number of ```Students``` for credit and are guided by again a number of ```Instructors```. It is a Series of ```Weeks```. To avoid conflict with ```Students``` I will use ```W``` showing one ```Studio```.

### Week (w)
A ```Week``` is one cycle within a ```Studio``` which there is a class session to evaluate the ```Plans``` from the ```Students```. In Our simulation, this will be the time factor.

### Plan (p)
A ```Plan``` is a architecture proposal that will be proposed by a ```Student```. A Plan has one or many ```Criteria```, which indicates different factors of evaluation. For Simplicity, our models will select two for the number of ```Criteria```.

### Criterion (c)
A ```Criterion``` is one scale to characterize A ```Plan```. A ```Criterion``` takes values from 0-1 in real numbers. Note that a ```Criterion``` value does not directly implicate the quality, meaning 1 (or 0) does not mean it is the best (or the worst) possible value.

In Reality ```Criterion``` range in ambiguity, examples for one ```Criterion``` might be vague ones like, aesthetics, or the level of integration, or solid distinct ones like simply budget. I will save the discussion of different criteria have different scales and interpretation. Also, another abstraction will be the notion that our ```Studio``` has a predefined set of ```Criterion``` in a priori.

#### Best Plan (b)
This ```Best Plan``` is a ```Plan``` that is most valued. Every ```Students``` goal is be close as possible at the end of the ```Studio```, which obviously no student knows the ```Best Plan``` in before hand. It is left open to the ```Instructor Rule
``` whether the ```Instructors``` knows the ```Best Plan```.

### Student (s)
A ```Student``` produces a ```Plan``` in every given cycle. A ```Student``` 's goal is to create a Plan which is closest to the  ```Best Plan```. There will be multiple strategies how to create one ```Plan``` which will be defined as the ```Student Rule```.

### Instructor (i)
The ```Instructor``` evaluates (or critiques) the Plans and gives a value how good the proposed ```Plan``` to the ```Student``` in each week. ```Instructors``` have different rules how to calculate the value, where it is not obvious that the ```Instructor``` knows the best ```Plan```, the set of rules will be defined as the ```Instructor Rule```.
