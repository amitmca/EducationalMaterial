<?
 	function xstrcat($s1,$s2)
        {
                return $s1.$s2;
        }
                                                                                                    
        function xreplace($s1,$s2,$pos)
        {
                                                                                                    
                for($i=0;$i<strlen($s2);$i++)
                {
                        $s1[$i+$pos] = $s2[$i];
                }
                return $s1;
        }
?>
