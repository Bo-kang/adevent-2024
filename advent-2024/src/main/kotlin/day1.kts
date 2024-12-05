import kotlin.math.absoluteValue

object Day1{

    fun partOne(firstList: List<Int>, secondList: List<Int>) : Int{
        var answer = 0
        firstList.sorted()
            .let { f ->
                secondList.sorted()
                    .let { s->
                        for(i in firstList.indices){
                            answer += ( f[i] - s[i] ).absoluteValue
                        }
                    }
            }
        return answer
    }

    fun partTwo(firstList: List<Int>, secondList: List<Int>) : Int{
        var answer = 0
        firstList.sorted()
            .forEach { fValue ->
                secondList.count{ sValue ->
                    fValue == sValue
                }.run {
                    answer += fValue * this
                }
            }
        return answer
    }
}

val input = """
    88450   63363
    58674   73195
    30431   97265
    79176   36224
    51071   64526
    78115   34829
    26281   65342
    99747   75563
    81068   41201
    81760   39590
    91539   66113
    51799   96883
    69353   19440
    64094   96883
    27283   88579
    52983   37831
    36638   37255
    68035   36007
    26604   96883
    43449   69865
    90472   75289
    20731   35412
    31769   42457
    37135   22483
    64018   44347
    49545   45637
    87888   11937
    89770   85917
    39164   26074
    34963   57264
    69433   87585
    89828   75289
    51940   30644
    76011   76423
    86044   69863
    42178   81634
    58537   84529
    68039   39015
    91534   80235
    95383   26816
    72575   20171
    63014   53853
    32766   84529
    21621   89301
    65716   94131
    74270   26729
    73720   99746
    22637   82429
    96044   16327
    93882   19601
    49123   36007
    59778   64129
    62853   55358
    72347   80203
    48833   47045
    64129   62494
    21955   96883
    92027   12818
    38750   29622
    16496   92138
    68900   26494
    13007   75255
    15450   75255
    82750   57264
    35089   36007
    60190   26729
    92533   72231
    95863   46766
    28192   34386
    36229   31291
    84353   84529
    85760   94567
    68643   63363
    47794   81334
    26171   63475
    14558   25238
    73997   72059
    56966   79382
    26572   86541
    15302   89301
    25557   89301
    52311   84529
    83219   10771
    47897   38681
    51489   33757
    10737   70282
    14395   57593
    75289   33474
    50622   53826
    33690   96463
    88570   36007
    88810   37995
    76440   71407
    96318   30287
    17056   63363
    90971   75246
    26526   85772
    64411   41201
    41386   10166
    16374   92034
    69742   91071
    71716   23782
    52237   32193
    63724   35412
    29598   55182
    58958   55182
    70562   56476
    99313   47299
    99705   70328
    38730   36007
    93620   29617
    64261   33757
    37597   26576
    86139   77794
    81816   20568
    25422   63744
    41188   26729
    91310   94596
    42798   61799
    12672   96315
    51173   45929
    23901   79382
    86756   95419
    72786   33757
    21624   90149
    81152   20260
    76279   75816
    86686   60299
    96883   79162
    52777   54244
    44760   69775
    48872   50008
    13502   66090
    39968   94596
    49634   17015
    90616   79382
    98097   94596
    94918   36224
    71745   76703
    63978   94596
    96485   96984
    34269   66751
    86448   64129
    40845   35412
    24852   28792
    49514   37277
    60306   41587
    19242   81203
    42110   55182
    88579   19310
    14788   36076
    22896   77018
    53083   89301
    21419   62087
    16682   40987
    45509   63363
    19280   80435
    35886   81329
    25186   22123
    72836   88497
    97528   96823
    72387   18771
    83455   86201
    33568   86544
    30442   94455
    83110   29374
    49301   88579
    34315   69117
    41298   86008
    55295   97010
    35412   88552
    52239   68865
    31395   26729
    26416   51263
    62441   69129
    43014   92675
    73780   55669
    59350   99109
    61061   22458
    41617   18191
    49483   35412
    58955   33400
    36007   37276
    10241   35159
    46681   33757
    89126   36224
    33265   38854
    95319   13101
    73018   20969
    60322   26729
    50982   88579
    12810   57845
    16293   33757
    74375   28399
    63806   18191
    66212   85298
    65902   32364
    88549   12193
    41289   15659
    68097   14208
    88017   30570
    73445   22551
    38360   15738
    39931   47827
    30391   46615
    46148   17015
    50563   33757
    55685   74778
    88469   69721
    22810   57264
    32215   74778
    59903   15150
    17397   57264
    10767   17015
    99371   18191
    90831   51790
    65156   94131
    97534   74778
    91168   84518
    26858   70445
    29539   87613
    30333   71407
    99445   73344
    16567   94131
    32900   69357
    27489   63148
    46422   63363
    91270   37691
    19540   53813
    65489   45632
    76210   98226
    29062   27996
    41201   74778
    45915   88579
    94945   81121
    54375   41217
    21536   17358
    75870   30864
    79743   89214
    20691   94596
    10352   83523
    83970   30864
    98914   18386
    58938   55182
    51275   11339
    86583   95003
    69981   47537
    27674   84373
    43824   47258
    87336   25451
    56054   20831
    33272   54103
    36755   63991
    73434   10847
    36649   82725
    80713   71407
    13544   74784
    27841   88579
    84003   22246
    48985   68185
    10176   71407
    58353   22559
    15647   74778
    68910   41553
    46401   31790
    80269   22871
    86290   47068
    95993   10051
    44568   41201
    44398   66153
    41393   84557
    30042   18191
    31917   38515
    13513   59458
    71906   89301
    75883   73018
    95352   64129
    14275   63363
    69876   35412
    16298   31473
    30864   79382
    19877   81988
    22165   16975
    62660   18191
    72656   13418
    81487   69274
    72705   79382
    22301   88579
    81495   94131
    88386   77944
    71675   21687
    34867   50027
    41331   74778
    53633   96823
    54664   42918
    29793   43797
    68537   94131
    46224   88579
    36246   75957
    68342   16975
    94273   33645
    97185   26729
    23728   63363
    68264   29231
    79652   26729
    89531   20323
    98937   94073
    91690   94596
    48648   67496
    32882   40888
    57264   71920
    13447   95151
    35448   64129
    75778   98592
    23234   27536
    49904   64383
    26513   17296
    91793   13262
    27874   74776
    66884   71407
    45213   64129
    40497   84529
    76273   23793
    39230   36224
    89266   29166
    35518   85657
    16168   94208
    20476   58668
    87694   93276
    45088   29626
    60101   92034
    33643   46999
    84013   36057
    45702   52055
    82641   36007
    20831   96883
    77611   96823
    82075   84749
    56470   18508
    19621   11287
    59631   21505
    64405   73018
    19772   36007
    86905   95374
    17583   26729
    53767   33757
    37207   40318
    94596   73018
    51890   38283
    52083   30246
    10991   37453
    33366   61295
    70856   40290
    84010   75289
    95694   77859
    57389   49009
    38239   36007
    92555   55182
    83182   98585
    66779   73018
    89448   30783
    82430   55798
    96968   63363
    93774   96883
    85440   59291
    94915   76935
    81147   25407
    71130   91090
    74977   84529
    74557   55182
    22159   75441
    31266   66927
    98350   20323
    13272   26729
    95602   91096
    88655   10128
    74822   68720
    11346   89301
    52663   28749
    20323   61116
    94621   75255
    27159   42996
    61249   44166
    22861   88579
    64142   83623
    29355   22533
    23153   94131
    28248   36007
    70448   60535
    53405   20323
    38065   92034
    37806   32005
    88000   43943
    72790   84856
    33687   34647
    11417   69129
    53871   63990
    45748   51721
    95328   16975
    59125   16975
    12587   96823
    94131   34262
    42511   38283
    52071   60452
    73868   33171
    38312   38283
    98418   56577
    85457   88579
    16464   89301
    76815   24744
    28900   88027
    49734   96738
    92985   57264
    86926   74778
    93208   57264
    41938   88579
    67527   93270
    49205   26792
    41165   20323
    40200   81976
    59357   20831
    75079   97383
    60169   63363
    92074   10369
    18585   96883
    43719   65952
    71503   61691
    20439   41201
    50067   42595
    89766   94596
    20035   79104
    29197   34472
    82716   92034
    15062   84529
    91337   41587
    23698   74778
    86500   64129
    52046   28042
    40868   67872
    96384   34853
    60434   73018
    56290   14749
    57746   40512
    18898   68267
    51209   38283
    67029   49628
    40530   26729
    63443   70371
    69441   72474
    73700   35412
    41594   24791
    51804   75289
    45731   16482
    36815   74778
    47389   36007
    34424   48448
    31341   35412
    69202   64129
    47466   45163
    13481   35412
    82208   62440
    52875   24907
    38932   57264
    10312   89301
    99845   66120
    26735   67913
    90820   80814
    64199   30409
    99821   35412
    80212   79866
    54094   23997
    94967   55182
    18831   76412
    69611   88579
    20794   42343
    18926   33757
    17242   60919
    78473   69441
    13515   33757
    84378   73018
    18489   67992
    12314   67269
    29089   69129
    68433   57264
    87740   17015
    78290   55182
    83596   83443
    16316   58265
    45777   36224
    50505   26729
    73351   49921
    23112   72074
    29172   74778
    11572   73018
    63218   98846
    10094   81881
    46797   75255
    27552   29062
    31740   42212
    52505   37612
    84303   79266
    18826   17378
    80340   36224
    69924   35412
    37554   25059
    57758   88579
    12994   75289
    28474   89301
    98133   96823
    59181   89301
    19715   20323
    57509   14174
    48026   73018
    10803   76950
    34768   17015
    73776   75743
    23928   29064
    20765   52954
    44968   17011
    47992   55182
    22902   87954
    42359   79382
    38908   65592
    94050   89301
    25874   89204
    10650   71407
    39759   24477
    17442   70977
    73455   63363
    43244   51733
    36224   63523
    24323   24865
    40462   80381
    77474   80809
    57622   13765
    47172   32125
    51053   71446
    38866   75255
    14536   81935
    18191   34338
    50783   94131
    32218   73018
    65928   98893
    33554   43527
    48966   94596
    68980   96823
    92199   17370
    47624   98708
    81484   96883
    36264   10166
    86887   41536
    56559   20799
    69481   15846
    95563   48609
    48042   94131
    89886   41856
    32235   91508
    75609   74778
    93104   49394
    78119   56999
    73185   31883
    66947   35412
    10279   82579
    74932   79382
    46673   94131
    16885   64129
    50651   42094
    79768   51705
    55122   69129
    75702   26729
    42522   92034
    81922   17576
    67535   92034
    56847   84529
    95298   36007
    79649   30220
    80679   88023
    39366   94131
    72233   72394
    45780   71407
    27048   34309
    72918   27570
    11115   79811
    18720   16379
    78049   89301
    25027   30864
    39170   73018
    72551   36224
    38283   63363
    71042   39139
    93626   65171
    97077   69322
    44993   88579
    99937   36007
    92127   79382
    89301   64129
    34485   96823
    70901   63363
    93765   64129
    22641   47498
    96940   94131
    69328   77254
    48593   33757
    62393   76585
    50116   55182
    31287   88361
    46213   35412
    86316   45354
    52095   63363
    73009   39645
    76994   36224
    52768   96883
    58014   91861
    38328   79382
    86656   28792
    24198   35412
    20644   96823
    80856   48773
    85514   69129
    78541   79504
    89198   69441
    66843   19369
    42847   80534
    10506   71407
    53734   50401
    56950   33757
    10097   42731
    11735   35718
    47055   15050
    62723   96459
    46747   45849
    85689   45896
    26070   33757
    24973   79382
    98067   40236
    10839   60254
    83064   71407
    11426   41587
    53675   88894
    42916   17015
    26729   56376
    85296   18191
    70877   88315
    59363   94131
    90177   91923
    65577   26729
    22974   84529
    82930   88579
    48640   69441
    77227   69768
    21808   71796
    12093   36292
    57834   26729
    85449   79076
    31321   58970
    29147   21478
    54452   96883
    36762   94179
    77729   30525
    38806   95982
    16975   12420
    59754   38283
    92634   96918
    75255   72045
    20579   94596
    10838   30864
    72028   33757
    34045   31285
    10166   54162
    39450   17015
    79156   64765
    99772   88914
    66119   58424
    84505   57996
    79335   23710
    22607   18562
    70069   69129
    56842   82046
    51924   26981
    53971   60458
    63946   36630
    58512   69441
    83844   84320
    73324   33757
    49874   14478
    96638   88579
    25651   92034
    35046   63158
    45863   50172
    33827   11916
    74271   71407
    92141   80677
    26165   94596
    29156   91383
    14258   65553
    99336   57264
    56949   19178
    29951   94131
    80133   26729
    69937   64129
    27282   35509
    37999   64333
    35714   32970
    74778   82464
    65706   63363
    28826   35412
    43880   57264
    65365   11878
    60998   53456
    23464   96883
    63996   71407
    47988   62639
    72134   68309
    43808   17923
    71794   64129
    55139   44545
    68486   70532
    88866   19086
    31014   73174
    25100   32701
    23168   77965
    86321   46763
    56564   97150
    66443   94876
    34574   26729
    18319   55182
    52080   63363
    34903   57264
    10503   73018
    73547   18191
    71407   36363
    14066   10066
    55291   38283
    49333   73182
    85590   31911
    31583   92034
    56885   94596
    10853   84529
    54330   26729
    60526   60376
    73313   37560
    64827   21896
    54707   41377
    78727   89301
    81267   42594
    97418   54093
    48561   90307
    27700   98842
    88852   25642
    27571   26729
    30253   18191
    96823   11966
    15510   28792
    34473   10074
    19128   92715
    66281   16359
    87566   55338
    73327   15839
    90546   73018
    10731   88579
    33757   35881
    53264   77702
    27559   14286
    76671   43247
    14652   56992
    66269   16975
    68360   35412
    47909   37394
    34184   27993
    56983   96823
    46159   47334
    17929   19802
    19939   33757
    54638   51325
    81041   71407
    82318   16975
    36922   87710
    37124   35412
    97802   99288
    44780   41201
    41587   29901
    79382   94596
    58560   24533
    49390   75255
    64184   64129
    63363   13174
    31139   94913
    41545   45809
    31298   79382
    27867   20831
    31915   89301
    57731   54824
    16568   39610
    37837   71407
    67097   36007
    66230   62450
    72316   10166
    93233   90637
    53568   38068
    30604   35412
    52867   72154
    94676   13310
    64541   64129
    75970   94040
    84132   63836
    23468   69030
    41002   63111
    25437   73018
    73367   89016
    61905   28740
    58157   57264
    40049   75255
    88306   88579
    41571   13741
    63613   86935
    81673   72916
    55528   60139
    27726   79382
    76018   20831
    93265   23625
    67182   26729
    21149   13330
    25611   84529
    84359   94134
    98940   88075
    91702   53729
    49126   92878
    67287   87543
    13917   96823
    38327   71407
    94612   12864
    55182   45518
    43277   74778
    31570   15210
    75076   69063
    80682   89301
    22072   69129
    12519   75255
    76313   64129
    67075   96823
    65234   57699
    43693   72346
    89876   29062
    17665   92034
    33737   36661
    91753   36730
    59183   43449
    14540   67538
    74552   79382
    12545   26729
    51062   30818
    96261   36224
    17961   86727
    41550   88380
    44693   18191
    56353   97146
    26427   68693
    10521   55270
    50199   78554
    55779   71477
    13694   71407
    84529   35412
    28117   94596
    28792   79382
    86182   23320
    72131   80477
    49826   74426
    34390   74778
    74094   16341
    69129   34543
    50073   92706
    37199   88579
    37972   32503
    88066   55182
    84391   31812
    33375   89622
    84125   64129
    68050   62191
    80017   35566
    89775   80938
    43499   69441
    93020   48741
    28839   69441
    65343   71722
    82862   46646
    35994   75255
    94975   88579
    66142   36828
    65082   26265
    85699   45338
    49094   65410
    89012   69332
    12731   32597
    12574   50774
    23300   79382
    59711   20831
    48379   19665
    26444   73931
    94298   55575
    64549   25462
    85255   33757
    18260   15074
    89345   39774
    47964   96883
    30500   75255
    40701   13580
    85115   63598
    56810   57264
    49698   74778
    60564   57264
    16225   71407
    89966   85122
    61233   14073
    31511   41588
    33945   73524
    98473   31768
    41456   64129
    85038   87448
    73588   96883
    25283   86498
    33280   13657
    49275   20323
    87664   77882
    47908   57264
    33245   58814
    42158   28925
    22933   72601
    60641   63363
    79702   44349
    78739   17205
    22561   96035
    43533   21008
    71914   12918
    14862   15368
    17015   89301
    73903   93498
    43166   85414
    90888   78097
    43451   33757
    99167   55182
    71516   86059
    51747   78573
    37581   94131
    12993   79382
    32228   96328
    69475   33757
    54981   23543
    81379   33567
    80367   35412
    58566   94131
    26053   35412
    77442   80466
    70340   17984
    83405   14607
    59197   85280
    98773   49233
    32734   94596
    53611   52671
    45926   94927
    53823   53295
    31731   20323
    97782   95936
    92678   43308
    98973   47522
    63484   89301
    29604   60237
    74422   93965
    80370   58449
    89621   75255
    27363   31734
    11198   90186
    88033   42157
    93444   24578
    35116   55182
    16393   73018
    33628   38645
    67211   57264
    24757   20323
    73181   35191
    24567   76180
    84081   15390
    34345   10519
    21185   17015
    33414   96823
    30310   72888
    24352   57264
    56004   14161
    14492   39140
    47871   75255
    42912   92034
    91823   36007
    46731   73158
    24112   74778
    92034   95808
    77157   89301
    29215   99938
    37580   89301
    73593   36007
    11075   96823
    49084   34885
""".trimIndent()

fun processInput(input: String, idx: Int = 0): List<Int> {
    return input.split("\n")
        .map { it.split("   ").map { it.toInt() } }.map { it[idx] }
}

println(Day1.partOne(processInput(input), processInput(input, 1)))
println(Day1.partTwo(processInput(input), processInput(input, 1)))