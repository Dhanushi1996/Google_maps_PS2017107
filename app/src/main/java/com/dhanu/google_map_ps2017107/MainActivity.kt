package com.dhanu.google_map_ps2017107

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dhanu.google_map_ps2017107.models.Place
import com.dhanu.google_map_ps2017107.models.UserMaps

const val EXTRA_USER_MAP="EXTRA_USER_MAP"
private const val TAG="MainActivity"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userMaps=generateSampleData()
        val rvMaps:RecyclerView=findViewById(R.id.rvMaps)
        rvMaps.layoutManager=LinearLayoutManager(this)
        rvMaps.adapter = MapsAdapter(this, userMaps, object : MapsAdapter.OnClickListener{
            override fun onItemClick(position: Int) {
                Log.i(TAG, "onItemClick $position")
                val intent = Intent(this@MainActivity,MapsActivity::class.java)
                intent.putExtra(EXTRA_USER_MAP,userMaps[position])
                startActivity(intent)
            }

            })


        }
    private fun generateSampleData(): List<UserMaps> {
        return listOf(
            UserMaps("Eastern University of Sri Lanka",
                listOf(
                    Place("Eastern University of Sri Lanka", "Eastern Province,Sri Lanka", 7.794505687507148, 81.57902782594998),

                    )
            ),
            UserMaps("University of Colombo",
                listOf(
                    Place("University of Colombo", "Western Province,Sri Lanka",6.900142708567335, 79.85883671199475),
                )
            ),

            UserMaps("University of Jaffna",
                listOf(
                    Place("University of Jaffna", "North Province,Sri Lanka", 9.685096417522068, 80.02208049475486),

                    )
            ),
            UserMaps("University of Sri Jayawardhanapura",
                listOf(
                    Place("University of Sri Jayawardhanapura", "Western Province,Sri Lanka", 6.8532445273150095, 79.90310478325068 ),

                    )
            ),

            UserMaps(
                "University of Kelaniya",
                listOf(
                    Place("University Of Kelaniya", "Western Province,Sri Lanka", 6.9741928826886515, 79.91567259038584,),

                    )
            ),
            UserMaps("University of Moratuwa",
                listOf(
                    Place("University of Moratuwa", "Western Province,Sri Lanka", 6.795345991213557, 79.90084553943908),

                    )
            ),

            UserMaps("University of Peradeniya",
                listOf(
                    Place("University of Peradeniya", "Central Province,Sri Lanka", 7.255172444609407, 80.59737568083767),

                    )
            ),
            UserMaps("Rajarata University of Sri Lanka",
                listOf(
                    Place("Rajarata University of Sri Lanka", "North Central Province,Sri Lanka", 8.358532558438952, 80.5033465961451),

                    )
            )
            ,
            UserMaps("University of Ruhuna",
                listOf(
                    Place("University of Ruhuna", "Southern Province,Sri Lanka", 5.938785632087819, 80.5760656109992),

                    )
            ),
            UserMaps("Sabaragamuwa University of Sri Lanka",
                listOf(
                    Place("Sabaragamuwa University of Sri Lanka", "Sabaragamuwa Province,Sri Lanka", 6.714756351426805, 80.78723995477858),

                    )
            ),
            UserMaps("South Eastern University of Sri Lanka",
                listOf(
                    Place("South Eastern University of Sri Lanka", "South Eastern Province,Sri Lanka",7.297040498005531, 81.85015120098964),
                )
            ),
            UserMaps("Uva Wellassa University of Sri Lanka",
                listOf(
                    Place("Uva Wellassa University of Sri Lanka", "Uva Province,Sri Lanka", 6.982059949352772, 81.07630498730482),

                    )
            ),
            UserMaps("University of Visual and Performing Arts",
                listOf(
                    Place("University of Visual and Performing Arts", "Western Province,Sri Lanka", 6.910263845740226, 79.86242359526481),

                    )
            ),

            UserMaps("Wayamba University of Sri Lanka",
                listOf(
                    Place("Wayamba University of Sri Lanka", "Wayamba Province,Sri Lanka", 7.322795259353432, 79.98818411060707),

                    )
            )

        )
    }
}