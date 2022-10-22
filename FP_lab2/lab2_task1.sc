(define (sq x err)  ; функція квадрату
    (define (sq2 x yn  yn-1  err ) ;  функція квадрату внутрішня
        
      (if   ( < (abs (- yn yn-1)) err) ; перевірка чи функція змінюється менше чим похибка
            yn        
            (sq2 x (* 0.5 (+ yn (/ x yn))) yn  err  ); рекурсивний виклик функції
        );
         
    )
  
    (sq2 x 1 1000 err); початковий виклик функції
          )

(define (interval1 a b h err); функція інтервалу
    (interval a b h a err )
    
    )

(define (interval a b h t err); внутрішня функція інтервалу
    
    
    (define (f1 a b h t err); для першогї умови
        
        (newline)
        (display "t= ")
        (display t)
         (newline)
        (display "rez=")
        (display (+ (sq (- t 1) err ) (sq (+ t 1) err)))
        (newline)
        
        (display "rez_real=")
        (display (+ (sqrt (- t 1)  ) (sqrt (+ t 1) )))
        (newline)
        
         (interval a b h (+ t h)  err) 
        
        )
    
    ( define (f2 a b h t err); для другої умови
      (newline)
        (display "t= ")
        (display t)
            (newline)
        (display "rez     =")
        
            (display(  /  1 (sq  (- (* t t ) 1) err)))
            (newline)
             (display "rez_real=")
            (display(  /  1 (sqrt  (- (* t t ) 1) )))
            (newline)
            
            
            
            
             (interval a b h (+ t h)  err); 
      
      )
    
    (cond ( ( or (< t 0 ) (= t 0)   );умова 1
            (f1 a b h t err);
   
      )
    
       
           ( ( or (< t b ) (= t b) ); умова 2
            
            (f2 a b h t err);
              )
            
            
        (else 1);
       
        ))

( interval1 2 4 0.5  0.0001 ); виклик функції  інтервалу
(newline);