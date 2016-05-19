package com.artivisi.android.kyurifood.headoffice.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.artivisi.android.kyurifood.headoffice.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RegionalFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RegionalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegionalFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    Button btn_tambah;
    Dialog addRegional;
    ListView listregional;

    public RegionalFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RegionalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RegionalFragment newInstance(String param1, String param2) {
        RegionalFragment fragment = new RegionalFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view =  inflater.inflate(R.layout.fragment_regional, container, false);

        listregional = (ListView)view.findViewById(R.id.regional_list);
        listregional.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final CharSequence[] dialogregion = {"Edit","Delete"};
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Pilih Menu");
                builder.setItems(dialogregion, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int region) {
                       switch (region){
                           case 0:
                               Toast.makeText(getActivity(),"Edited",Toast.LENGTH_SHORT).show();
                               break;
                           case 1:
                               Toast.makeText(getActivity(),"Deleted",Toast.LENGTH_SHORT).show();

                               break;
                       }
                    }
                });
                builder.create().show();
                return false;


            }
        });

        btn_tambah = (Button)view.findViewById(R.id.btn_tmbh_regional);
        btn_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddRegional();
            }

            private void showAddRegional() {
                addRegional = new Dialog(getActivity());
                addRegional.setContentView(R.layout.tambah_regional);
                addRegional.setTitle("Add Regional");
                addRegional.setCancelable(false);
                addRegional.show();

                Button but = (Button) addRegional.findViewById(R.id.cancel);
                but.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        addRegional.dismiss();
                    }
                });
                Button ok = (Button) addRegional.findViewById(R.id.ok);
                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        addRegional.dismiss();
                    }
                });




            }
        });

        return view;

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
