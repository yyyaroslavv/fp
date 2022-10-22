

( define (f1 a b x0  err  f df  ); зовнішня функція
  
    (define (f2 n n-1 err  f df );  внутрішня функція
        
    ( if ( < ( abs (- n n-1 )) err ); перевірка на точність
        n
      ( f2  (- n  (/ (f n) (df n) ) )  n err f df )
      
      )    
    
    )
    ; (display (df 2 ))
   
     ( let (( x (f2  x0 100  err  f df  ) )) ;запущення внутрішньої функції 

    (if ( and  (> x a ) (< x b) )
        x
        (begin 
            (display "вихід за діапазон х ="  )
            x
    
            
            )
        ) 
    )
   
    )
(display "1 спосіб: =")
(display( f1  -10 10 -2  0.00001    ( lambda ( x )( -(- (* x x)  (* 2 (cos x) ) )    1  ) )     ( lambda ( x )( + ( * 2 x ) (* 2 (sin x))  ) )  )      ); виклик функції
(newline)

( define (f1 a b err  f   ); зовнішня функція
  
    (define (f2 a b err f  );  внутрішня функція
        
    ( if ( < ( abs (- a b )) err ); перевірка на точність
        a
        (if ( < (* (f a ) ( f (/ (+ a b) 2) )     ) 0) 
            (f2 a (/ (+ a b) 2) err f  )
            (f2 (/ (+ a b) 2) b err f  )
            
            )     
      
      )    
    
    )
    ; (display (df 2 ))
   
              
     (if ( < (* (f a) (f b)  ) 0 )
     (f2   a b err f  )  ;запущення внутрішньої функції 
     " точки стоять по один бік від осі х"
     )
 
    )
(display "2 спосіб: =")
(display( f1  0 2 0.001  ( lambda ( x )( -(- (* x x)  (* 2 (cos x) ) )    1  ) )  )     ); виклик функції
(newline)
